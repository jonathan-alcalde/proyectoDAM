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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Panizo
 */
public class Servidor extends Thread {

    //Método que implementa el comportamiento del hilo
    @Override
    public void run() {
        try {
            System.out.println("Servidor - Se abre un socket servidor en el puerto 1112 de la máquina local");
            //Puerto del servidor
            int puertoServidor = 1112;
            //El cliente se conecta al servidor
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            System.out.println("Servidor - Se crea un ArrayList para almacenar los manejadores de sockets de los clientes");
            ArrayList<SesionServidor> sesiones = new ArrayList();
            System.out.println("Servidor - El servidor queda a la espera indefinidamente de todas las conexiones de cleinte que se produzcan");
            Socket clienteConectado;
            SesionServidor sesion;
            while (true) {
                clienteConectado = socketServidor.accept();
                sesion = new SesionServidor(clienteConectado);
                sesiones.add(sesion);
                sesion.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
