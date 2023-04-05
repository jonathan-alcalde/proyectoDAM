/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian Panizo
 */
public class Cliente extends Thread {

    private String nombre;
    private String mensaje;

    //Constructor del cliente.
    public Cliente(String nombre, String mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    //Método que implementa el comportamiento del hilo
    @Override
    public void run() {
        try {
            System.out.println("Cliente " + nombre + " - Estableciendo conexión con 1112");
            //IP del servidor
            String equipoServidor = "127.0.0.1";
            //Puerto del servidor
            int puertoServidor = 1112;
            //El cliente se conecta al servidor
            Socket socketCliente = new Socket(equipoServidor, puertoServidor);
            gestionarComunicacion(socketCliente);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
    Método que envía un mensaje al servidor y recoge un mensaje que el servidor
    le envía
    */
    public void gestionarComunicacion(Socket socketCliente) {
        try {
            System.out.println("\t Cliente " + nombre + " - El cliente construye el mensaje y lo envía al servidor");
            OutputStream os = socketCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("Soy " + nombre + ", " + mensaje);
            System.out.println("\t Cliente " + nombre + " - El cliente ha recibido un mensaje del servidor y procede a mostrarlo por consola");
            InputStream is = socketCliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println("\t Cliente " + nombre + " - Mensaje recibido del Servidor: " + dis.readUTF());
            
            is.close();
            dis.close();
            os.close();
            dos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
