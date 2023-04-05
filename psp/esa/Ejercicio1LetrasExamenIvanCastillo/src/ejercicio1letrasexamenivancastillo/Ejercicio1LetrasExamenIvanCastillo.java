/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1letrasexamenivancastillo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author DAM204
 */
public class Ejercicio1LetrasExamenIvanCastillo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorService servicio1 = Executors.newCachedThreadPool(); //creacion del servicio que gestiona los hilos "Letra"
        Letra l1 = new Letra("Ivan");   //creación de un hilo letra llamado Ivan
        Letra l2 = new Letra("Pepe");   //creación de un hilo Letra llamado Pepe
        
        servicio1.submit(l1);   //añadir el hilo Letra l1 al ExecutorService servicio1
        servicio1.submit(l2);   //añadir el hilo Letra l2 al ExecutorService servicio2
        
        servicio1.shutdown();   //finalización del ExecutorService servicio1
        
        ExecutorService servicio2 = Executors.newCachedThreadPool(); //creacion del servicio que gestiona los hilos "Letra"
        Letra l3 = new Letra("Juan");   //creación de un hilo letra llamado Juan
        Letra l4 = new Letra("Pedro");  //creación de un hilo letra llamado Pedro
        
        servicio2.submit(l3);   //añadir el hilo Letra l3 al ExecutorService servicio2
        servicio2.submit(l4);   //añadir el hilo Letra l4 al ExecutorService servicio2
        
        servicio2.shutdown();   //finalización del ExecutorService servicio2
    }
    
}
