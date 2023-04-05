/**
 * En este ejemplo se muestra:
 *  1. Cómo gestionar hilos para el acceso a una sección critica mediante semáforos compartidos. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola306A.c -o PMHConsola306A -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola306A
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h> 
#include <pthread.h> 
#include <semaphore.h> 
#include <unistd.h> 

sem_t mutex; //semaforo compartido por todos los hilos

void* thread(void* arg) { 

    pid_t		pid;
	pthread_t	tid;
	pid = getpid();
	tid = pthread_self();
	
	//wait 
	sem_wait(&mutex); 
    printf("Datos del hilo: pid=%u tid=%u (0x%x)\n", (unsigned int)pid, (unsigned int)tid, (unsigned int)tid);
	printf("\nEntro en SC..\n"); 
	//La SC se modela mediante un sleep
	sleep(4); 
	
	//signal 
	printf("\nSalgo de la SC\n"); 
	sem_post(&mutex); 
} 


int main()  { 
	sem_init(&mutex, 0, 1); //se inicializa el semaforo compartido al valor 1. El 0 indica que es compartido entre los hilos de un proceso , pero no entre procesos
	
    //Se crean 2 hilos manejados por la misma rutina thread
    pthread_t t1,t2; 
	pthread_create(&t1,NULL,thread,NULL); 
	//sleep(2); 
	pthread_create(&t2,NULL,thread,NULL); 
	pthread_join(t1,NULL); 
	pthread_join(t2,NULL); 
	
    //finalmente se destruye el semaforo compartido
    sem_destroy(&mutex); 
	return 0; 
} 
