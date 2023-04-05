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

/**
 *
 * @author Adrian Panizo
 */
public class SesionServidor extends Thread {
    
    private Socket clienteConectado;

    public SesionServidor(Socket clienteConectado) {
        this.clienteConectado = clienteConectado;
    }
    
    @Override
    public void run () {
        try {
            System.out.println("Servidor - El servidor ha recibido un mensaje de algún cliente y procede a mostrarlo por consola");
            InputStream is;
            is = clienteConectado.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String mensaje = dis.readUTF();
            System.out.println("Servidor - Mensaje recibido del Cliente: " + mensaje);
            
            System.out.println("Servidor - El servidor responde al cliente");
            OutputStream os = clienteConectado.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            if(mensaje.contains("bombero") || mensaje.contains("fuego") || mensaje.contains("incendio") || mensaje.contains("agua")) {
                dos.writeUTF("SE LE ASIGNARÁ BOMBEROS");
                Thread bomberos = new Bomberos();
                bomberos.start();
            } else if(mensaje.contains("hospital") || mensaje.contains("caída") || mensaje.contains("sangre") || mensaje.contains("ambulancia")) {
                dos.writeUTF("SE LE ASIGNARÁ HOSPITAL");
                Thread hospital = new Hospital();
                hospital.start();
            } else {
                dos.writeUTF("SE LE ASIGNARÁ POLICÍA");
                Thread policia = new Policia();
                policia.start();
            }
            
            is.close();
            dis.close();
            os.close();
            dos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
