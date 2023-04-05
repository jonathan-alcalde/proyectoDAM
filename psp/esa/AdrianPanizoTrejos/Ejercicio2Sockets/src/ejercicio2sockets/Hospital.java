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
public class Hospital extends Thread {

    //Método que implementa el comportamiento del hilo
    @Override
    public void run() {
        try {
            System.out.println("Hospital - Se abre un socket servidor en el puerto 1093 de la máquina local");
            //Puerto del servidor
            int puertoHospital = 1093;
            //El cliente se conecta al servidor
            ServerSocket socketHospital = new ServerSocket(puertoHospital);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
