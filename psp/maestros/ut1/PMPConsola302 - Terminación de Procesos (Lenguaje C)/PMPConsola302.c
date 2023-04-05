/**
 * En este ejemplo se muestra:
 *  1. Cómo realizar distintas maneras de terminar a un proceso. El proceso padre crea 3 hijos:
 *     Al hijo1 le envia la señal SIGKILL para que termine inmediatamente
 *     Al hijo2 le envia la señal SIGUSR para que éste la capture y termine adecuadamente con exit(0)
 *     Al hijo3 hay que enviarle la señal de terminacion desde otra terminal, escribiendo el comando
 *     kill -s SIGKILL [PID]
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola302.c -o PMPConsola302
 * lbb@ubuntu:~$ ./PMPConsola302
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include<stdio.h>
#include<signal.h>
#include<unistd.h>
#include <errno.h>

void sigusr1_handler(int signo) {
    if (signo == SIGUSR1){
        printf("Recibida la señal SIGUSR1. Termino con exit(0).\n");
	exit(0);
    }
}

int main(void) {
    printf("Se mostrarán distintas formas de terminar procesos.\n");
    pid_t pid1, pid2, pid3;
    int status1, status2, status3;
    if ( (pid1=fork()) == 0 ) {
	//El proceso hijo1
	printf("Soy el hijo1: escribo mi pid cada segundo hasta recibir señal SIGKILL.\n");
        while(1){
 		printf("hijo1 (PID=%d)\n", getpid());
		sleep(1);
	}
    }
    else{
	sleep(2);
	if ( (pid2=fork()) == 0 ) {
	   //El proceso hijo2
           if (signal(SIGUSR1, sigusr1_handler) == SIG_ERR)
        	printf("No se puede capturar la señal SIGUSR1.\n");
	   printf("Soy el hijo2: escribo mi pid cada segundo hasta recibir señal USR1 para terminar con exit(0).\n");
           while(1){
 		printf("hijo2 (PID=%d)\n", getpid());
		sleep(1);
	   }
        }
	else{
	    sleep(2);
	    if ( (pid3=fork()) == 0 ) {
		printf("Soy el hijo3: escribo mi pid cada segundo hasta recibir señal kill desde otra terminal.\n");
           while(1){
 		printf("hijo3 (PID=%d)\n", getpid());
		sleep(1);
		printf("Para terminar conmigo, abre otra terminal y escribe: kill -s SIGKILL %d\n", getpid());
	   }
	    }
	    else {
		/*El proceso padre espera por la finalización de todos sus hijos*/
		sleep(5);
		printf("Voy a terminar a mis procesos hijos.\n");
		printf("Al hijo1 le envio la señal SIGKILL:\n");
		kill(pid1, SIGKILL);

		while(waitpid(pid1,NULL,0)){
		   if(errno==ECHILD){
		      printf("El hijo1 (PID=%d) ha terminado tras enviarle la señal SIGKILL.\n", pid1);
		      break;
	           }
		}
		//sleep(2);
		printf("Al hijo2 le envio la señal SIGUSR1:\n");
		kill(pid2, SIGUSR1);

		while(pid2 = waitpid(pid2,NULL,0)){
		   if(errno==ECHILD){
		      printf("El hijo2 (PID=%d) ha terminado correctamente con exit(0) tras enviarle la señal SIGUSR1.\n", pid2);
                      break;
	           }
		}                
//		sleep(2);
		printf("Para terminar con el hijo3, abre otra terminal y escribe $>kill -s SIGKILL %d\n", pid3);
		while(pid3 = waitpid(pid3,NULL,0)){
		   if(errno==ECHILD){
		      printf("El hijo3 (PID=%d) ha terminado correctamente tras enviarle la señal KILL desde otra terminal.\n", pid3);
                     break;
	           }
		}
		printf("Soy el proceso padre y termino porque ya terminaron mis hijos.\n");		
            }
    	}
    }
    return 0;
}
