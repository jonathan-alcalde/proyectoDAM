/**
 * En este ejemplo se muestra:
 *  1. Cómo enviar una señal de hibernacion (SIGSTOP) a un proceso y que luego se restablezca al recibir otra señal (SIGCONT) continuando su ejecucion.  
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola303.c -o PMPConsola303
 * lbb@ubuntu:~$ ./PMPConsola303
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <errno.h>
#include <limits.h>

void sig_handler(int signo) {
	if (signo == SIGCONT){
	    printf("\nRecibida la señal SIGCONT\n\n");
        }
}

int main(void) { 
   pid_t pid;
   if ( (pid=fork()) == 0 ) {
	printf("Soy el proceso hijo (PID=%d). Voy a escribir enteros:\n", getpid());
	//el proceso hijo debe capturar la señal SIGCONT (la señal SIGSTOP no se puede ignorar)
        if (signal(SIGCONT, sig_handler) == SIG_ERR)
        	printf("No se puede capturar la señal SIGCONT.\n");
        int i=0;
	while(1){
	   if(i%500000==0)
	       printf("@%d\t", i/500000);
	   i++;
	   if(i==INT_MAX)
		break;
	}
	printf("\nEl proceso hijo (PID=%d) va a finalizar.\n", getpid());
	exit(0);
    }
    else{
	sleep(2);
	printf("\n\nEl proceso padre (PID=%d) manda al hijo (PID=%d) la señal SIGSTOP para parar.\n", getpid(), pid);
	//El proceso padre manda señal SIGSTOP al hijo para que éste se suspenda.
	kill(pid, SIGSTOP);
	//5 segundos después le pide al hijo que se reanude (con la señal SIGCONT)
	printf("En 5 segundos, el proceso padre manda al hijo la señal SIGCONT para reanudar.\n\n");
	sleep(5);
	kill(pid, SIGCONT);

	/*El proceso padre espera por la finalización de su hijo*/
        while(pid = waitpid(pid,NULL,0)){
		if(errno==ECHILD){
                break;
	    }
        }
	printf("\nEl proceso padre (PID=%d) va a finalizar.\n", getpid());
    }
    return 0;

}
