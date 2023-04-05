/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2sockets;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Adrian Panizo
 */
public class Bomberos extends Thread {

    //Método que implementa el comportamiento del hilo
    @Override
    public void run() {
        try {
            System.out.println("Bomberos - Se abre un socket servidor en el puerto 1091 de la máquina local");
            //Puerto del servidor
            int puertoBomberos = 1091;
            //El cliente se conecta al servidor
            ServerSocket socketBomberos = new ServerSocket(puertoBomberos);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
