/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpspdam203_ejercicio2;

/**
 *
 * @author DAM203
 */
public class ExamenPSPDAM203_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        //CREAMOS SERVIDOR Y CLIENTE Y LOS INICIAMOS
        Thread servidorUDP = new ServidorUDP();
        Thread cliente = new ClienteUDP("PEPE");

        servidorUDP.start();
        cliente.start();

    }
}
