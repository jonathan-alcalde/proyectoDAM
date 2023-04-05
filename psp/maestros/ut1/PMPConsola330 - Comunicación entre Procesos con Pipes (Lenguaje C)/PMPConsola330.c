/**
 * En este ejemplo se muestra:
 * 1. Cómo comunicar procesos padre-hijo mediante pipes. El proceso padre crea el pipe y crea al proceso hijo.
 * El hijo enlaza la salida estandar al pipe, ejecuta el comando "date" y termina.
 * El padre enlaza la entrada estandar al pipe, recibiendo así el resultado del comando. Luego compara para
 * averiguar el dia actual y muestra mensaje. Finalmente cierra el pipe y termina.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola330.c -o PMPConsola330
 * lbb@ubuntu:~$ ./PMPConsola330
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>
#include <string.h>

struct {
    char    *abrev;
    char    *nombre;
} dias[] = {
    "lun",  "Lunes",
    "mar",  "Martes",
    "mie",  "Miercoles",
    "jue",  "Jueves",
    "vie",  "Viernes",
    "sab",  "Sabado",
    "dom",  "Domingo",
    0,      0
};

int main(void) {
    pid_t pid;
    int pfd[2];
    int i, status;
    char linea[64];
    
     /* Crear pipe.*/
    if (pipe(pfd) < 0) {
        perror("pipe");
        exit(1);
    }

    /* Crear proceso hijo.*/
    if ((pid = fork()) < 0) {
        perror("fork");
        exit(1);
    }

    /* El proceso hijo ejecuta el comando "date". */
    if (pid == 0) {
        printf("El proceso hijo (PID=%d) une su salida a la entrada de su padre y ejecuta el comando DATE ", getpid());
        /* Unir la salida estandar al pipe. */
        dup2(pfd[1], 1);
        close(pfd[0]);

        execl("/bin/date", "date", (char *) 0);
        perror("exec");
        exit(0);
    }

    /* Cerramos el descriptor 1 del pipe. */
    close(pfd[1]);

    /* Leer la salida del comando "date": Los 3 primeros caracteres son la abreviatura del dia actual. */
    if (read(pfd[0], linea, 3) < 0) {
        perror("read");
        exit(1);
    } 

    /* Para cada dia, se mira si coincide con la salida del comando "date" y se muestra mensaje. */
    printf("¿Que dia es hoy?\n");
    for (i=0; dias[i].abrev != NULL; i++) {
        if (strncmp(linea, dias[i].abrev, 3) == 0)
            printf("Hoy es %s.\n", dias[i].nombre);
        else
            printf("Hoy no es %s.\n", dias[i].nombre);
    }

    /* Cerrar el pipe y esperar por la finalizacion del hijo */
    close(pfd[0]);
    wait(&status);

    /* exit(0) para indicar finalizacion exitosa */
    exit(0);
}

