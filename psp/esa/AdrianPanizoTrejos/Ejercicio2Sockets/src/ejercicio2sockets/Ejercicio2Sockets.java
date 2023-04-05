/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2sockets;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Panizo
 */
public class Ejercicio2Sockets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread servidor = new Servidor();
        servidor.start();

        Thread cliente = new Cliente("Adrian", "sangre");
        cliente.start();
    }

}
