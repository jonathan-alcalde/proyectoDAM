/**
 * En este ejemplo se muestra:
 *  1. Cómo gestionar hilos para el acceso a una sección critica mediante mutex y variables condicionales. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola307B.c -o PMHConsola307B -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola307B
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h> 
#include <stdlib.h> 
#include <pthread.h> 
#include <unistd.h> 
#include <assert.h>

#define N 5
#define TAMANIO 1024

void *trabajador(void *); 
void yield();
void randomize();

//los datos compartidos
int vector[TAMANIO];
struct barrera_s {
	int n;
	pthread_mutex_t mutex;
	pthread_cond_t llegaron;
} barrera;


//rutina hilo trabajador
void * trabajador(void *arg) {
	int val;
	int i;
	val = *(int *)arg; 
	printf("Soy el hilo_%d\n", val);
	yield();

	pthread_mutex_lock(&barrera.mutex);
    	
	for(i=0; i<TAMANIO; i+=val) {
		vector[i] = val; 
        	yield();
	}
	printf("Termino %d\n", val);


//	pthread_mutex_lock(&barrera.mutex);
    //	yield();

	barrera.n++;
	if (barrera.n<N) {
		//faltan de llegar 
		printf("Hilo_%d pasó la barrera. Faltan %d por llegar.\n", val, N-barrera.n);
		pthread_cond_wait(&barrera.llegaron, &barrera.mutex);
        	//yield();
	} else {    
		//todas las componentes llegaron
		printf("Todas las componentes llegaron.\n");
		pthread_cond_broadcast(&barrera.llegaron);
        	//yield();
	}
	pthread_mutex_unlock(&barrera.mutex);
    	yield();

	return 0;
}


int main(int argc, char *argv[]) {
	pthread_t hilo_1, hilo_2, hilo_3, hilo_4, hilo_5;
	int uno, dos, tres, cuatro, cinco;

	//cambio la semilla de los numeros aleatorios
	randomize();

	//inicializacion de los datos compartidos
	barrera.n = 0;
	pthread_mutex_init(&barrera.mutex, NULL);
	pthread_cond_init(&barrera.llegaron, NULL);
	//creacion de los hilos
	uno=1; dos=2; tres=3; cuatro=4, cinco=5;


	pthread_create(&hilo_1, NULL, trabajador, (void *)&uno);
	pthread_create(&hilo_2, NULL, trabajador, (void *)&dos);
	pthread_create(&hilo_3, NULL, trabajador, (void *)&tres);
	pthread_create(&hilo_4, NULL, trabajador, (void *)&cuatro);
	pthread_create(&hilo_5, NULL, trabajador, (void *)&cinco);		

	
	pthread_join(hilo_1, NULL);
	pthread_join(hilo_2, NULL);	
	pthread_join(hilo_3, NULL);	
	pthread_join(hilo_4, NULL);
	pthread_join(hilo_5, NULL);
	
	

	//espero que terminen
	//destruyo la estructura
	pthread_cond_destroy(&barrera.llegaron);
	pthread_mutex_destroy(&barrera.mutex);

	printf("Todos los hilos pasaron la barrera. El vector queda asi:");
	for(int i=0; i<TAMANIO; i++) {
		printf("v[%d]=%d\t", i, vector[i]); 
		if(i%10==0) printf("\n");

	}

	return 0;
} 


//se entrega al planificador de manera no deterministica
void yield(void) {
	if (rand()%N)
		sched_yield();
}

//Función para randomizar sobre el buffer compartido
void randomize(void) {
	FILE *fd;
	unsigned int read;
	unsigned int buffer;
	fd = fopen("/dev/random","r");
	read = fread((void *)&buffer, sizeof(unsigned int), 1, fd);
	srand(buffer);
}
