/**
 * En este ejemplo se muestra:
 * 1. Cómo implementar un mecanismo de procesos productores/consumidores. En este caso el proceso padre y el
 * proceso hijo comparten elementos través de una tuberia. El padre produce un elemento que el hijo consume, durante 10 iteraciones. 
 * Para compilar y ejecutar este proyecto, será necesario disponer de un compilador de C para crear el ejecutable. En sistemas UNIX/Linux:
 * lbb@ubuntu:~$ gcc PMPConsola335B.c -o PMPConsola335B
 * lbb@ubuntu:~$ ./PMPConsola335B
 * @author Luis de Blas
 * @version 1.0
 * @since PSP 1.0
*/
#include <unistd.h>
#include <stdio.h>
#include <time.h>

void productor(int esc) {
  int i;
  for (i=1; i<=10; i++) {
    int elemento = rand();;
    write(esc, &elemento, sizeof elemento);
    printf("PID(%d) Produzco: %d\n", getpid(), elemento);
    sleep(1);
  }
  exit(0);
}


void consumidor(int lec) {
  int leidos, i;
  while ((leidos = read(lec, &i, sizeof i)) > 0) {
     printf("PID(%d) Consumo: %d\n", getpid(), i);
  }
  exit(0);
}

int main(void) {
  int pid, tubo[2];
  printf("Este ejemplo muestra el problema del productor/consumidor mediante pipes.\n");
  pipe(tubo);
  if ((pid= fork())==0) {
    close(tubo[1]);
    consumidor(tubo[0]);
  }
  else {
    close(tubo[0]);
    productor(tubo[1]);
  }
}


