/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Adrian Panizo
 */
public class Ejercicio1Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ExecutorService servicio1 = Executors.newCachedThreadPool();
        ExecutorService servicio2 = Executors.newCachedThreadPool();
        
        
        Abecedario a = new Abecedario();
        Semaphore s = new Semaphore(1);
        
        Tarea tarea1 = new Tarea(1,a,s);
        Tarea tarea2 = new Tarea(2,a,s);
        Tarea tarea3 = new Tarea(3,a,s);
        Tarea tarea4 = new Tarea(4,a,s);
        
        servicio1.submit(tarea1);
        servicio1.submit(tarea2);
        
        servicio2.submit(tarea3);
        servicio2.submit(tarea4);
        
        servicio1.shutdown();
        servicio2.shutdown();
    }
    
}
