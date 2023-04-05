/**
 * En este ejemplo se muestra: Productor/Consumidor con hilos y mutex con vbles de condición
 *  1. Cómo gestionar hilos para el problema productor/consumidor a una sección critica mediante mutex y variables condicionales. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola307C.c -o PMHConsola307C -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola307C
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h> 
#include <unistd.h> 
#include <assert.h>

#define MAX_BUFFER 1024 /* Tamaño del buffer */
#define DATOS_A_PRODUCIR 100000 /* Datos a producir */
pthread_mutex_t mutex; /* Mutex que controla acceso al buffer */
pthread_cond_t no_lleno; /* Controla el llenado del buffer */
pthread_cond_t no_vacio; /* Controla el vaciado del buffer */
int n_elementos; /* Número de elementos en el buffer */
int buffer[MAX_BUFFER]; /* Buffer común */

void * Productor (void * arg) { /* Código del Productor */
    int dato, i ,pos = 0;
    for(i=0; i < DATOS_A_PRODUCIR; i++ ) {
        dato = i; /* Producir dato */
        pthread_mutex_lock(&mutex); /* Acceder al buffer */
        while (n_elementos == MAX_BUFFER) /* Si buffer lleno */ {
        	printf("El buffer esta lleno.\n");
	    	pthread_cond_wait(&no_lleno, &mutex); /* se bloquea */
	}
        buffer[pos] = i;
        pos = (pos + 1) % MAX_BUFFER;
        n_elementos ++;
        printf("Produce %d en la pos %d y hay %d elems.\n", dato, pos, n_elementos); /* Consume dato */
        pthread_cond_signal(&no_vacio); /* Buffer no vacío */
        pthread_mutex_unlock(&mutex);
    }
    pthread_exit(0);
}

void * Consumidor (void * arg) { /* Código del Consumidor */
    int dato, i ,pos = 0;
    for(i=0; i < DATOS_A_PRODUCIR; i++ ) {
        pthread_mutex_lock(&mutex); /* Acceder al buffer */
        while (n_elementos == 0) /* Si buffer vacío */ {
	    printf("El buffer esta vacio!\n");
	    pthread_cond_wait(&no_vacio, &mutex); /* se bloquea */
	}
        dato = buffer[pos];
        pos = (pos + 1) % MAX_BUFFER;
        n_elementos --;
        printf("Consume %d desde la pos %d y quedan %d elems.\n", dato, pos, n_elementos); /* Consume dato */
        pthread_cond_signal(&no_lleno); /* Buffer no lleno */
        pthread_mutex_unlock(&mutex);

    }
    pthread_exit(0);
}

int main(int argc, char *argv[]) {
    pthread_t th1, th2;
    pthread_mutex_init(&mutex, NULL);
    pthread_cond_init(&no_lleno, NULL);
    pthread_cond_init(&no_vacio, NULL);
    pthread_create(&th1, NULL, Productor, NULL);
    pthread_create(&th2, NULL, Consumidor, NULL);
    pthread_join(th1, NULL);
    pthread_join(th2, NULL);
    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&no_lleno);
    pthread_cond_destroy(&no_vacio);
    exit(0);
}
