/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2serviciosexamenivancastillo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author DAM204
 */
public class Cliente extends Thread {

    private String nombre;
    private String mensaje;
    private String equipoServidor;

    public Cliente(String nombre, String mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            equipoServidor = "127.0.0.1";   //ip del servidor al cual se conecta el cliente
            int puertoServidor = 1112;      //puerto en el que se aloja el servidor al que se conecta el cliente
            Socket socketCliente = new Socket(equipoServidor, puertoServidor);  //creación del socket que permite la conexion del cliente con el servidor
            gestionarComunicacion(socketCliente);
            
            socketCliente.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Metodo que envia un mensaje al servidor y mediante ese mensaje el servidor le enviara un puerto al que posteriormente el servidor se conectara con un socket para que ese otro servidor le mande un mensaje que cuadre con el suyo
    public void gestionarComunicacion(Socket socketCliente) {
        try {
            OutputStream os = socketCliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(mensaje);
            
            InputStream is = socketCliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int puertoServicio = dis.readInt();
            
            
            
            Socket socketClienteServicio = new Socket(equipoServidor, puertoServicio);
            OutputStream osServicio = socketClienteServicio.getOutputStream();
            DataOutputStream dosServicio = new DataOutputStream(osServicio);
            dosServicio.writeUTF(mensaje);
            
            InputStream isServicio = socketClienteServicio.getInputStream();
            DataInputStream disServicio = new DataInputStream(isServicio);
            String mensajeServicio = disServicio.readUTF();
            System.out.println("Soy " + nombre + " y he recibido el mensaje " + mensajeServicio);
            
            is.close();
            dis.close();
            os.close();
            dos.close();
            osServicio.close();
            dosServicio.close();
            isServicio.close();
            disServicio.close();
            socketClienteServicio.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
