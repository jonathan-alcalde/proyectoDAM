/**
 * En este ejemplo se muestra:
 *  1. Cómo sincronizar procesos mediante semáforos compartidos. El proceso padre debe esperar a que el proceso hijo ejecute una instrucción 
 * para poder continuar su ejecución.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola310.c -o PMPConsola310
 * lbb@ubuntu:~$ ./PMPConsola310
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <semaphore.h>
#include <sys/mman.h>

int main(){
sem_t * semSincro = mmap(NULL, sizeof(* semSincro), PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);
if(semSincro==MAP_FAILED){
   printf("Error al crear el semaforo en Mem. Compartida.\n");	
   exit(-1);
}
if(sem_init(semSincro, 1, 0)==-1){
   printf("Error al inicializar el semaforo.\n");	
   exit(-1);
}
pid_t pid= fork();

if(pid==-1){
   printf("Error al llamar a fork.\n");	
   exit(-1);
}
if(pid!=0){
   //proceso padre
   int valSemPadre; 
   sem_getvalue(semSincro, &valSemPadre);
   printf("El valor del semaforo para el padre es: %d.\n", valSemPadre);
   printf("El proceso padre(de pid %d) debe esperar a que el proceso hijo(de pid %d) ejecute la instrucción bloqueante.\n", getpid(), pid);
   fflush(stdout);
   sem_wait(semSincro);
   printf("El proceso padre continua su ejecución.\n");
   if(sem_destroy(semSincro)==-1){
      printf("Error al destruir el semaforo.\n");	
      exit(-1);
   } 
   else{
      printf("El padre ha destruido correctamente el semaforo.\n");	
   }
}
else{
   //proceso hijo
   printf("Soy el proceso hijo (de pid %d).\n", getpid());
   int valSemHijo; 
   sem_getvalue(semSincro, &valSemHijo);
   printf("El valor del semaforo para el hijo es: %d.\n", valSemHijo);
   fflush(stdout);
   sleep(5); //la instrucción bloqueante se modela con este sleep(5)
   printf("El proceso hijo (de pid %d) ya ejecutó la instrucción bloqueante.\n", getpid());
   sem_post(semSincro);
   sem_getvalue(semSincro, &valSemHijo);
   printf("El valor del semaforo es: %d.\n", valSemHijo);
}
printf("El proceso de pid %d va a terminar.\n", getpid());
   if(munmap(semSincro, sizeof(semSincro))==-1){
      printf("Error al desmontar el semaforo de la Mem. Compartida.\n");	
      exit(-1);
   }
exit(0);
}
