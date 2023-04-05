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
public class Hospital extends Thread{
    
    @Override
    public void run() {
        try {
            int puertoServidor = 1093;
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            
            Socket clienteConectado;
            while (true) {
                clienteConectado = socketServidor.accept();
                InputStream is = clienteConectado.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String mensajeCliente = dis.readUTF();
                System.out.println("Mensaje recibido a hospital: " + mensajeCliente);
                OutputStream os = clienteConectado.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Tranquilo, ya estamos mandando una Ambulancia");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
