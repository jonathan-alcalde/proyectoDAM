/**
 * En este ejemplo se muestra:
 * 1. Cómo implementar un mecanismo de procesos productores/consumidores. En este caso se dispone de un buffer de elementos de tamaño máximo 3. Se simula las operaciones de producir y consumir elementos de ese buffer. El mecanismo de sincronizacion y comunicacion entre ellos esa través de semaforos.
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola335A.c -o PMPConsola335A
 * lbb@ubuntu:~$ ./PMPConsola335A
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/

#include<stdio.h>

int mutex=1; /*Semaforo global*/
int lleno=0; /*Inicialmente el buffer se encuentra vacio*/
int vacio=3; /*El tamaño máximo del buffer es de 3 elementos. */
int x=0;

int wait(int a){
        return(--a);
}

int signal(int b){
        return(++b);
}

void productor() {
        mutex=wait(mutex);
        lleno=signal(lleno);
        vacio=wait(vacio);
        x++;
        printf("Producido el elemento %d\n", x);
        printf("Elementos disponibles: %d\n", x);
        mutex=signal(mutex);
}

void consumidor() {
    mutex=wait(mutex);
    lleno=wait(lleno);
    vacio=signal(vacio);
    printf("Consumido el elemento %d\n", x);
    x--;
    printf("Elementos restantes: %d\n", x);
    mutex=signal(mutex);
}

int main() {
    int n;
    void productor();
    void consumidor();
    int wait(int);
    int signal(int);
    
    while(1) {
	printf("\n1.Producir\t2.Consumir\t3.Salir");
        printf("\nMarque su opción:");
        scanf("%d",&n);
        switch(n) {
            case 1:    
		if((mutex==1)&&(vacio!=0))
                        productor();
                else
                        printf("El buffer está lleno (max %d elementos)\n", x);
                break;
            case 2:    
		if((mutex==1)&&(lleno!=0))
                        consumidor();
                else
                        printf("El buffer está vacio\n");
                break;
            case 3:
                exit(0);
	    default:
			printf("Opcion incorrecta.");
        }
    }

    return 0;
}

