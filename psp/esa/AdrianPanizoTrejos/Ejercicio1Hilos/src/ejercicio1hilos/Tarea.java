/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1hilos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrian Panizo
 */
public class Tarea implements Runnable {
    int valor;
    Abecedario a;
    Semaphore s;
    
    /**
     * Constructor que pèrmite inicializar el hilo con el valor asignado al
     * hilo, el recurso compartido (que contiene el vector de 10 posiciones) y 
     * el semáforo que va a permitir o bloquear el acceso al recurso compartido     * 
     * @param valor Valor asignado al hilo
     * @param a Recurso compartdo que contiene el vector de 10 posiciones
     * @param s Semáforo que permite o bloquea el acceso al recurso compartido 
    */
    public Tarea(int valor, Abecedario a, Semaphore s) {
        this.valor = valor;
        this.a = a;
        this.s = s;
    }
    
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run() {
        wait_sem();
        System.out.println("Motrando el hilo " + valor);
        a.mostrar();
        signal_sem();
    }
    
    /**
     * Método que implementa el método wait del hilo
    */
    public void wait_sem() {
        try {
            s.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
    /**
     * Método que implementa el método signal del hilo
    */
    public void signal_sem() {
        s.release();
    }
}
