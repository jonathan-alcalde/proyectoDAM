/**
 * En este ejemplo se muestra: Problema de productor/consumidor con Hilos y Semáforos
 *  1. Cómo gestionar hilos para el acceso a una sección critica mediante semáforos compartidos. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola306B.c -o PMHConsola306B -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola306B
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <pthread.h>
#include <semaphore.h>

#define NOTSHARED 0
#define N 16
#define NUM_ITEMS 1024

void *productor(void *);
void *consumidor(void *);
void yield();

//la estructura compartida
struct buffer_sync_s {
	int buffer[N+1];
	int pr, pw; //posicion en el buffer en la que: pr=leer (consumir) o pw=escribir (producir)
	pthread_mutex_t mutex;
	sem_t vacios;
	sem_t llenos;
} buffer_sync;


int main (int argc, char *argv[]) {
	pthread_t hilo_p, hilo_c;
	//init de la estructura
	buffer_sync.pr = buffer_sync.pw = 0;
	pthread_mutex_init(&buffer_sync.mutex, NULL);
	sem_init(&buffer_sync.vacios, NOTSHARED, N);
	sem_init(&buffer_sync.llenos, NOTSHARED, 0);
	//creo los hilos
	pthread_create(&hilo_p, NULL, productor, NULL);
	pthread_create(&hilo_c, NULL, consumidor, NULL);
	//espero que terminen
	pthread_join(hilo_p, NULL);
	pthread_join(hilo_c, NULL);
	//destruyo la estructura
	sem_destroy(&buffer_sync.llenos);
	sem_destroy(&buffer_sync.vacios);
	pthread_mutex_destroy (&buffer_sync.mutex);
	return 0;
}


//productor
void *productor (void *arg) {
	int i;

	for (i=0; i<NUM_ITEMS; i++) {
		yield();
		sem_wait(&buffer_sync.vacios);
		yield();
		pthread_mutex_lock(&buffer_sync.mutex);
		yield();
		//el buffer circular, encolar(i)
		buffer_sync.buffer[buffer_sync.pw] = i;
		yield();
		buffer_sync.pw = (buffer_sync.pw+1) % (N+1);
		yield();
		printf("produzco %5d en la posicion pw=%d\n", i, buffer_sync.pw);
		yield();
		pthread_mutex_unlock(&buffer_sync.mutex);
		yield();
		sem_post(&buffer_sync.llenos);
      		yield();
	}
	pthread_exit(NULL);
}


//consumidor, totalmente simetrico
void *consumidor (void *arg) {
	int i;
	int a;

	for (i=0; i<NUM_ITEMS; i++) {
		yield ();
		sem_wait(&buffer_sync.llenos);
		yield();
		pthread_mutex_lock(&buffer_sync.mutex);
		yield();
	
		//el buffer circular, decolar(i)
		a = buffer_sync.buffer[buffer_sync.pr];
		yield();
		buffer_sync.pr = (buffer_sync.pr+1) % (N+1);
		yield();
		printf("consumo %5d desde la posicion pr=%d\n", a, buffer_sync.pr);
		yield();
	
		pthread_mutex_unlock(&buffer_sync.mutex);
		yield();
		sem_post(&buffer_sync.vacios);
		yield();
	}
	pthread_exit(NULL);
}


//se entrega al planificador de manera no deterministica
void yield (void) {
	if (rand()%2)
		sched_yield();
}
