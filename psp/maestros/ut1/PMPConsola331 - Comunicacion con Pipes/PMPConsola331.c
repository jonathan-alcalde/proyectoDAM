/**
 * En este ejemplo se muestra:
 * 1. Cómo comunicar procesos padre-hijo mediante pipes. Se crea el pipe se crea al proceso hijo.
 * El hijo enlaza la salida estandar al pipe, ejecuta el comando "date" y termina.
 * El padre enlaza la entrada estandar al pipe, recibiendo así el resultado del comando. Luego compara para
 * averiguar el dia actual y muestra mensaje. Finalmente cierra el pipe y termina.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola331.c -o PMPConsola331
 * lbb@ubuntu:~$ ./PMPConsola331
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/


#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

#define LEER 0
#define ESCRIBIR 1 
int main ()    {    
	int descr[2];/* Descriptores de E y S de la turbería */    
	int  bytesleidos;    
	char mensaje[100], *frase="Veremos si la transferecia es buena.";
	printf ("Ejemplo de tuberia entre padre e hijo.\n");    

	pipe (descr);    
	printf("Creado el pipe: descr[0]=stdin y descr[1]=stdout\n");
	if (fork () == 0){ //proceso hijo
		printf("Soy el proceso hijo de PID=%d\n", getpid());
		close (descr[LEER]);       
		printf("Hijo: cierro descr[0]=entrada del pipe.\n");
		write (descr[ESCRIBIR], frase, strlen(frase));       	
		printf("Hijo: escribo en descr[1]=salida del pipe.\n");
		close (descr[ESCRIBIR]);     
		printf("Hijo: cierro descr[1]=salida del pipe.\n");
		  
	}    
	else {  //proceso padre     
		printf("Soy el proceso padre de PID=%d\n", getpid());
		close (descr[ESCRIBIR]);       
		printf("Padre: cierro descr[1]=salida del pipe.\n");
		bytesleidos = read (descr[LEER], mensaje, 100);
		printf("Padre: leo por descr[0]=entrada del pipe.\n");       
		printf ("Bytes leidos: %d\n", bytesleidos);       
		printf ("Mensaje: %s\n", mensaje);       
		close (descr[LEER]);       
		printf("Padre: cierro descr[0]=entrada del pipe.\n");
	}

}
