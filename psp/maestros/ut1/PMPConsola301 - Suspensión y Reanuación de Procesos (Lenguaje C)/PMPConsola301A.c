/**
 * En este ejemplo se muestra:
 *  1. Cómo hacer que un proceso se suspenda y que se reanude por otro proceso: el proceso padre queda suspendido hasta que se produzca la finalización de alguno de sus procesos hijos (wait)
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola301A.c -o PMPConsola301A
 * lbb@ubuntu:~$ ./PMPConsola301A
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

int main(){
int numhijos=3;
int * estado_hijo;
pid_t pid;
for(int i=0; i<numhijos; i++){
   pid= fork();
   if(pid==0){
      //proceso hijo recien creado duerme
      printf("El proceso hijo (de pid %d) duerme %d segundos...\n", getpid(), i);
      sleep(i);
      break;
   }
   else {
      printf("Soy el proceso padre (de pid %d) y he creado ya %d hijos...\n", getpid(), i+1);
      //continue;
   }
}


if(pid!=-1){
   if(pid!=0){
      //proceso padre
      	printf("El proceso padre (de pid %d) espera por la señal de finalizacion de algun hijo...\n", getpid());
      do{
     	pid_t hijofinalizado = wait(&estado_hijo);
        printf("El padre es notificado de la finalizacion de algun hijo, concretamente del proceso %d\n", hijofinalizado);
        numhijos = numhijos-1;
        printf("Al proceso padre le quedan %d hijos por acabar.\n", numhijos);
      } while(numhijos > 0);
   }
   else{
      //proceso hijo      
      printf("El proceso hijo (de pid %d) se despierta y avisa al padre de que va a finalizar.\n", getpid());
      exit(0);
   }
}
else{
   printf("Error al llamar a fork.\n");	
   exit(-1);
}

return 0;
}
