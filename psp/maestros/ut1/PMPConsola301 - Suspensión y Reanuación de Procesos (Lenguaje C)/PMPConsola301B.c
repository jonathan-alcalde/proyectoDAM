/**
 * En este ejemplo se muestra:
 *  1. Cómo hacer que un proceso se suspenda y que se reanude por otro proceso: el proceso padre queda suspendido hasta que se produzca la finalización de un proceso hijo concreto (waitpid)
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola301B.c -o PMPConsola301B
 * lbb@ubuntu:~$ ./PMPConsola301B
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

int main(){
pid_t pid= fork();
int * estado_hijo;

if(pid!=-1){

   if(pid!=0){
      //proceso padre
      printf("El proceso padre (de pid %d) espera por la señal de finalizacion del hijo (de pid %d)...\n", getpid(), pid);
      pid_t hijofinalizado= waitpid(pid, &estado_hijo, NULL);
      printf("El padre (de pid %d) es notificado de la finalizacion del hijo %d.\n", getpid(), hijofinalizado);
      printf("El proceso padre duerme 2 segundos más antes de acabar.\n");
      sleep(2);
   }
   else{
      //proceso hijo
      printf("El proceso hijo de pid %d duerme 5 segundos...\n", getpid());
      sleep(5);
      printf("El proceso hijo se despierta y avisa al padre de que va a finalizar.\n");
      exit(0);
   }


}
else{
   printf("Error al llamar a fork.\n");	
   exit(-1);
}
return 0;
}
