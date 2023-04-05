/**
 * En este ejemplo se muestra:
 *  1. Cómo manejar señales SIGINT, SIGUSR1, SIGKILL y SIGSTOP
 *  2. Cómo obtener el identificador del proceso padre de un proceso.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola305.c -o PMPConsola305
 * lbb@ubuntu:~$ ./PMPConsola305
 * Desde otra terminal de Linux, usar el comando kill para mandar las señales al PID del proceso
 * lbb@ubuntu:~$ kill -s SIGINT [PID]
 * lbb@ubuntu:~$ kill -s SIGUSR1 [PID]
 * lbb@ubuntu:~$ kill -s SIGSTOP [PID]
 * lbb@ubuntu:~$ kill -s SIGKILL [PID]
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include<stdio.h>
#include<signal.h>
#include<unistd.h>

static int contadorSIGINT=0; 
static int contadorSIGUSR1=0; 

void sig_handler(int signo)
{
    if (signo == SIGINT){
	contadorSIGINT++;
        printf("recibida la señal SIGINT %d veces.\n", contadorSIGINT);
    }
    else if (signo == SIGUSR1){
        contadorSIGUSR1++;
        printf("recibida la señal SIGUSR1 %d veces.\n", contadorSIGUSR1);
    }
    else if (signo == SIGKILL)
        printf("recibida la señal SIGKILL.\n");
    else if (signo == SIGSTOP)
        printf("recibida la señal SIGSTOP.\n");
}

int main(void) {
    //Se capturarán las señales SIGINT (ctrl+C) y SIGUSR1
    //Las señales SIGKILL y SIGSTOP no se pueden manejar
    if (signal(SIGINT, sig_handler) == SIG_ERR)
        printf("No se puede capturar la señal SIGINT.\n");
    if (signal(SIGUSR1, sig_handler) == SIG_ERR)
        printf("No se puede capturar la señal SIGUSR1.\n");
    if (signal(SIGKILL, sig_handler) == SIG_ERR)
        printf("No se puede capturar la señal  SIGKILL\n");
    if (signal(SIGSTOP, sig_handler) == SIG_ERR)
        printf("No se puede capturar la señal  SIGSTOP\n");
    //El proceso se queda esperando por la recepción de alguna señal
    while(1) 
        sleep(1);
        //pause();
    return 0;
}