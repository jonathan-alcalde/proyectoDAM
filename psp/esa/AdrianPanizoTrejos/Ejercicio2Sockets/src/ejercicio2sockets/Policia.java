/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Adrian Panizo
 */
public class Policia extends Thread {

    //Método que implementa el comportamiento del hilo
    @Override
    public void run() {
        try {
            System.out.println("Policía - Se abre un socket servidor en el puerto 1092 de la máquina local");
            //Puerto del servidor
            int puertoPolicia = 1092;
            //El cliente se conecta al servidor
            ServerSocket socketPolicia = new ServerSocket(puertoPolicia);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
