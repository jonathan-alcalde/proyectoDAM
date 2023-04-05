/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpspdam203_ejercicio1;

/**
 *
 * @author DAM203
 */
public class ExamenPSPDAM203_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos 2 hilos con su nombre
        Thread cliente1 = new ServicioLetras("Juan");
        Thread cliente2 = new ServicioLetras("Antonio");
        //ARANCAMOS LOS HILOS QUE ACTUARAN COMO DICTA SU METODO RUN
         cliente1.start();
        cliente2.start();
    }
    
}
