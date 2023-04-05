/**
 * En este ejemplo se muestra:
 *  1. Cómo crear un nuevo proceso con la llamada a fork() 
 *  2. Cómo distinguir entre el proceso padre y el proceso hijo
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola300B.c -o PMPConsola300B
 * lbb@ubuntu:~$ ./PMPConsola300B
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[])  {
   pid_t pid;
   pid = fork();
   
   int status;  

   if ( pid == -1 ) {
	printf("No se ha podido crear proceso hijo...");
        exit(-1);       
   }
   if ( pid == 0 ) { /* hijo */        
	printf("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es: %d. ...\n", getpid(), getppid() );	
   }
   else {   /* padre */
	printf("Soy el proceso padre:\n\t Mi PID es %d, El PID de mi padre es: %d.\n", getpid(), getppid());          
	wait(&status);
   }
   printf("Soy el proceso %d y voy a terminar ahora.\n", getpid());	
   return 0;
}
