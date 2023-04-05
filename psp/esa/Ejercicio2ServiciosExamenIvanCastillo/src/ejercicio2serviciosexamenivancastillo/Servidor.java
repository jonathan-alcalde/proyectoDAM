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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DAM204
 */
public class Servidor extends Thread {
   
    @Override
    public void run() {
        try {
            int puertoServidor = 1112;
            ServerSocket socketServidor = new ServerSocket(puertoServidor); //objeto que permite aceptar conexiones de objetos Socket
            
            Socket clienteConectado;
            while (true) {
                clienteConectado = socketServidor.accept();
                InputStream is = clienteConectado.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String mensajeCliente = dis.readUTF();
                int puerto; //puerto al que sera enviado el cliente dependiendo de su mensaje
                if (mensajeCliente.contains("bombero") || mensajeCliente.contains("fuego") || mensajeCliente.contains("incendio") || mensajeCliente.contains("agua")) { //Comprobación de si hay que enviar al cliente al puerto de los bomberos
                    puerto = 1091;
                    OutputStream os = clienteConectado.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(puerto);
                } else if (mensajeCliente.contains("policia") || mensajeCliente.contains("robo") || mensajeCliente.contains("ladrón") || mensajeCliente.contains("agresión")) { //Comprobación de si hay que enviar al cliente al puerto de la policia
                    puerto = 1092;
                    OutputStream os = clienteConectado.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(puerto);
                } else if (mensajeCliente.contains("hospital") || mensajeCliente.contains("caída") || mensajeCliente.contains("sangre") || mensajeCliente.contains("ambulancia")) { //Comprobación de si hay que enviar al cliente al puerto del hospital
                    puerto = 1093;
                    OutputStream os = clienteConectado.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(puerto);
                } else {    //Si no se cumple ningunas de las otras condiciones se envia al usuario al puerto de la policia
                    puerto = 1092;
                    OutputStream os = clienteConectado.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeInt(puerto);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
