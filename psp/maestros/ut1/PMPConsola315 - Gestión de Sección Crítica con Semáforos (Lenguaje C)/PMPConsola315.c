/**
 * En este ejemplo se muestra:
 *  1. Cómo sincronizar procesos mediante semáforos compartidos para el acceso exclusivo a una SECCIÓN CRÍTICA. 
 * Sólo un proceso puede ejecutar su Sección Critica a la vez, el resto esperan. La seccion critica corresponde con la escritura sobre una 
 * variable compartida de tipo int.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola315.c -o PMPConsola315 -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola315
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/


#include <stdio.h>          /* printf()                 */
#include <stdlib.h>         /* exit(), random()...      */
#include <sys/types.h>      /* key_t, sem_t, pid_t      */
#include <sys/shm.h>        /* shmat(), IPC_RMID        */
#include <errno.h>          /* errno, ECHILD            */
#include <semaphore.h>      /* sem_open(), sem_destroy(), sem_wait().. */
#include <fcntl.h>          /* O_CREAT, O_EXEC          */
#include <time.h>           /* time() */


int main (int argc, char **argv){
    int i;                        /*      loop variables          */
    key_t shmkey;                 /*      shared memory key       */
    int shmid;                    /*      shared memory id        */
    sem_t *sem;                   /*      semaphore para sincronizar procesos         *//*shared */
    pid_t pid;                    /*      fork pid                */
    int * vbleCompartida;         /*      shared variable         *//*shared */

    // inicializar la variable compartida en Mem. Compartida 
    shmkey = ftok ("/dev/null", 5);       /* valid directory name and a number */
    printf ("La clave shmkey para la vble compartida es %d\n", shmkey);
    shmid = shmget (shmkey, sizeof (int), 0644 | IPC_CREAT);
    if (shmid < 0){
        perror ("Error al tomar la clave de Mem. Compartida con shmget.\n");
        exit (-1);
    }
    vbleCompartida = (int *) shmat (shmid, NULL, 0);   /* mapear la vbleCompartida a la Mem. Compartida */
    *vbleCompartida = 0;
    printf ("La vble compartida queda alojada en Mem. Compartida y con el valor inicial %d.\n", *vbleCompartida);

    // inicializar el semaforo para el acceso a la seccion critica
    sem = sem_open ("semSC", O_CREAT | O_EXCL, 0644, 1); //El valor inicial del semaforo semSC es 1
    if(sem < 0){
        perror ("Error al inicializar semaforo con sem_open.\n");
        exit (-1);
    }
    printf ("Semaforo de la seccion critica inicializado.\n");

    printf ("Procedo a crear los 5 procesos hijo con fork().\n");
    for (i = 0; i < 5; i++){
        pid = fork ();
        if (pid < 0) {
            printf ("Error al llamar a fork().\n");
            /* limpieza de semaphores */
            sem_unlink ("semSC"); /* unlink previene de que el semaphore exista por siempre si ocurre alguna excepcion */
            sem_close(sem);  
        }
        else 
             if (pid == 0)
                 break;     // Los procesos hijo continuan la ejecución
             else 
                 printf("Creado hijo%d de pid %d.\n", i+1, pid);
    }

    if (pid != 0){
        //proceso padre
        printf("El proceso padre espera por la finalizacion de todos sus hijos.\n\n");
        while (pid = waitpid (-1, NULL, 0)){
            if (errno == ECHILD)
                break;
        }
        printf ("Padre: Todos los hijos han terminado.La vble compartida acaba valiendo %d.\n", *vbleCompartida);
        printf ("Padre: Procedo a liberar Mem. Compartida y limpiar semaforo.\n");
        /* liberar Mem. Compartida */
        shmdt (vbleCompartida);
        shmctl (shmid, IPC_RMID, 0);

        /* limpieza de semaphores */
        sem_unlink ("semSC");   /* unlink previene de que el semaphore exista por siempre si ocurre alguna excepcion */ 
        sem_close(sem);  
        printf("El proceso padre va a terminar.\n");
        exit (0);
    }
    else{
        //procesos hijo
        sem_wait (sem);           /* operacion Wait sobre el semaforo */
        printf ("El hijo de pid %d entra en la SC y la vble compartida vale %d.\n", getpid(), *vbleCompartida);
        sleep (1);
        srand(time(NULL));
        int incremento = rand() % 3;
        *vbleCompartida += incremento;   /* El proceso incrementa la vbleCompartida en 0, 1 o 2 aleatoriamente */
        printf ("El hijo de pid %d suma %d, por lo que vble compartida=%d.\n", getpid(), incremento,  *vbleCompartida);
        sem_post (sem);           /* operacion Post sobre el semaforo */
        printf("El hijo de pid %d sale de la seccion critica y va a terminar.\n\n", getpid());
        exit (0);
    }
}




