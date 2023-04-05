/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpspdam203_ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author DAM203
 */
//HILO CLIENTE
public class ClienteUDP extends Thread {
    
    String nombre;
    
    //COSNTRUCTOR DE CLIENTE
    public ClienteUDP(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método que implementa el comportamiento del hilo, NOS COENCTAMOS AL PUERTO 1112
     * MANDAMOS UN MENSAJE AL SERVIDOR en un datagrama
     * RECIBIMOS LA RESPEUSTA DEL SERVIDOR Y CERRAMOS EL CLIENTE
    */
    @Override
    public void run() {
        try {
            DatagramPacket datagrama;
            byte[] mensajeBytes = new byte[1024];
            int puertoCliente = 1000;
            DatagramSocket socketDatagrama = new DatagramSocket(puertoCliente);

            System.out.println("\t Cliente.Consola - Construyendo el datagrama a enviar al puerto 1112");
            InetAddress servidor = InetAddress.getLocalHost();
            int puertoServidor = 1112;
            
            //EN ESTE MENSAJE SERA LA SIMULACION DE LA COMUNICACION DEL CLIENTE, AQUI COMPRUEBA SI HAY PALABRAS CLAVE, 
            //PEUDES CAMBIAR PARA COMPROBAR SU FUNCIONAMIENTO
            String mensajeString = "HOLA MI NOMBRE ES " + nombre + " HAY UN FUEGO EN MI CASA";
            mensajeBytes = mensajeString.getBytes();
            
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length,servidor,puertoServidor);
            socketDatagrama.send(datagrama);
            
            System.out.println("\t Cliente.Consola - Esperando a recibir datagrama");
            mensajeBytes = new byte[1024];
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length);
            socketDatagrama.receive(datagrama);
            
            System.out.println("\t Cliente.Consola - Mostrando información de datagrama recibido");
            System.out.println("\t  Cliente.Consola - Mensaje recibido: " + new String(datagrama.getData()));
            
            
            System.out.println("\t Cliente.Consola - Cerrando datagrama");
            socketDatagrama.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
