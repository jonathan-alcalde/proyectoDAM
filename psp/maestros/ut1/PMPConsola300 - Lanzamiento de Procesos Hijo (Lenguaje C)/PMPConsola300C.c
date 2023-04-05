/**
 * En este ejemplo se muestra:
 *  1. Cómo crear un nuevo proceso con la llamada a fork() y que éste a su vez cree otro nuevo proceso. 
 *  2. Cómo distinguir entre el proceso abuelo, el proceso padre y el proceso hijo.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola300C.c -o PMPConsola300C
 * lbb@ubuntu:~$ ./PMPConsola300C
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
	pid_t pid1, pid2;
	int status1, status2;

	if ( (pid1=fork()) == 0 ) { /* hijo (1a generacion) = padre */
		if ( (pid2=fork()) == 0 ) { /* hijo (2a generacion)  = nieto */
			printf("Soy el nieto (%d, hijo de %d)\n", getpid(), getppid());
		}
		else { /* padre (2a generacion) = padre */
			printf("Soy el padre (%d, hijo de %d)\n", getpid(), getppid());
			wait(&status2);
		}
	}
	else { /* padre (1a generacion) = abuelo */
		printf("Soy el abuelo (%d, hijo de %d)\n", getpid(), getppid());
		wait(&status1);
	}
	printf("Soy el proceso %d, hijo de %d, y voy a terminar ya.\n", getpid(), getppid());
	return 0;
}


