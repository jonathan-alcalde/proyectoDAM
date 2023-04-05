/**
 * En este ejemplo se muestra EL PROBLEMA DEL BARBERO DORMILÓN
 * https://www.geeksforgeeks.org/dining-philosopher-problem-using-semaphores/
 *  1. Cómo sicronizar hilos y comunicarse entre ellos para el acceso a ciertas secciones criticas mediante semáforos compartidos. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMHConsola301.c -o PMHConsola301 -lpthread -lrt
 * lbb@ubuntu:~$ ./PMPConsola301
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/
#include <pthread.h> 
#include <semaphore.h> 
#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h>

#define FILOSOFOS 5 
#define PENSANDO 2 
#define HAMBRIENTO 1 
#define COMIENDO 0 
#define IZQ (filosofo + 4) % FILOSOFOS 
#define DCHA (filosofo + 1) % FILOSOFOS 

int estado[FILOSOFOS]; 
int filosofos[FILOSOFOS] = { 0, 1, 2, 3, 4 }; 

sem_t mutex; 
sem_t Semaforos[FILOSOFOS]; 

void test(int filosofo) { 
	if (estado[filosofo] == HAMBRIENTO 
		&& estado[IZQ] != COMIENDO 
		&& estado[DCHA] != COMIENDO) { 
		// estado cambia a COMIENDO 
		estado[filosofo] = COMIENDO; 
		sleep(2); 
		printf("El Filosofo %d toma los palillos %d y %d.\n", 
					filosofo + 1, IZQ + 1, filosofo + 1); 
		printf("El Filosofo %d esta COMIENDO\n", filosofo + 1); 

		// sem_post(&S[filosofo]) no tendria efecto during takefork 
		// used to wake up HAMBRIENTO Filosofos 
		// during putfork 
		sem_post(&Semaforos[filosofo]); 
	} 
} 

// tomar_palillo
void tomar_palillo(int filosofo) { 
	sem_wait(&mutex); 
	// estado cambia a HAMBRIENTO 
	estado[filosofo] = HAMBRIENTO; 
	printf("El Filosofo %d esta HAMBRIENTO\n", filosofo + 1); 
	// come si los vecios NO están COMIENDO 
	test(filosofo); 
	sem_post(&mutex); 
	// si no puede comer, se bloquea y espera a ser señalizado
	sem_wait(&Semaforos[filosofo]); 
	sleep(1); 
} 

// posar_palillo 
void posar_palillo(int filosofo) { 
	sem_wait(&mutex); 
	// estado cambia a PENSANDO 
	estado[filosofo] = PENSANDO; 
	printf("El Filosofo %d posa los palillos %d y %d.\n", 
		filosofo + 1, IZQ + 1, filosofo + 1); 
	printf("Filosofo %d esta PENSANDO\n", filosofo + 1); 
	test(IZQ); 
	test(DCHA); 
	sem_post(&mutex); 
} 

void* filosofo(void* num) { 
	while (1) { 
		int* i = num; 
		sleep(1); 
		tomar_palillo(*i); 
		sleep(0); 
		posar_palillo(*i); 
	} 
} 

int main() { 
	int i; 
	pthread_t thread_id[FILOSOFOS]; 
	// inicializar los semaphores 
	sem_init(&mutex, 0, 1); 

	for (i = 0; i < FILOSOFOS; i++) 
		sem_init(&Semaforos[i], 0, 0); 

	for (i = 0; i < FILOSOFOS; i++) { 
		// crear los hilos Filosofo 
		pthread_create(&thread_id[i], NULL,	filosofo, &filosofos[i]); 
		printf("El Filosofo %d esta PENSANDO\n", i + 1); 
	} 

	for (i = 0; i < FILOSOFOS; i++) 
		pthread_join(thread_id[i], NULL); 
} 
