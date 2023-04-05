/**
 * En este ejemplo se muestra:
 *  1. Cómo gestionar hilos para el acceso a una sección critica mediante mutex. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola307A.c -o PMHConsola307A -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola307A
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h> 
#include <unistd.h> 
#include <assert.h>

#define CAPACIDAD 16

void yield();
int buffer[CAPACIDAD];
pthread_mutex_t mutex;

void* thread(void* arg) { 
    pid_t		pid; //id de proceso
	pthread_t	tid; //id de hilo
	pid = getpid();
	tid = pthread_self();
	//valor (pasado al hilo como argumento) con el que establece los elementos del buffer compartido
	int val = *(int *)arg; 
	int i;

	//La SC en los hilos 	
	while(1) {
		yield();
		pthread_mutex_lock(&mutex);	
		//Inicio SC
		printf("\nAdquiero mutex y entro en SC con val=%d..\n", val);
		printf("Datos del hilo: pid=%u tid=%u (0x%x)\n", (unsigned int)pid, (unsigned int)tid, (unsigned int)tid);
		for (i=0; i<CAPACIDAD; i++) {
			buffer[i] = val;
			yield();
		}
		//Fin SC
		printf("\nSalgo de la SC y libero mutex.\n"); 
		pthread_mutex_unlock(&mutex);	
		yield();
	}	
	
} 


int main()  { 

	int val[2]={4,8};
	int i;
	for(i=0; i<CAPACIDAD; i++)
		buffer[i] = 0;
    //Se crean 2 hilos manejados por la misma rutina thread
    pthread_t t1,t2; 
	pthread_mutex_init(&mutex, NULL);
	pthread_create(&t1,NULL,thread, (void *)&val[0]); 
	pthread_create(&t2,NULL,thread, (void *)&val[1]); 
	pthread_join(t1,NULL); 
	pthread_join(t2,NULL); 

	while(1) {
		yield();
		pthread_mutex_lock(&mutex);	//Inicio SC
		printf("\nSoy el padre. Adquiero mutex y entro en SC con val=%d..\n", 0);
		printf("Datos del proceso: pid=%u\n", (unsigned int) getpid());
		for (i=0; i<CAPACIDAD; i++) {
			assert(buffer[i]==buffer[0]);
			yield();
		}
		printf("\nPadre: salgo de la SC y libero mutex.\n"); 
		pthread_mutex_unlock(&mutex);	//Fin SC
	}
	pthread_mutex_destroy(&mutex);
	return 0; 
} 


//se entrega al planificador de manera no deterministica
void yield(void) {
	if (rand()%2)
		sched_yield();
}
