/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpspdam203_ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author DAM203
 */

//SERVIDORUDP QUE EXTIENDE DE HILO
public class ServidorUDP extends Thread {
    
    //METODO DEL FUNCIONAMIENTO DEL SERVIDOR
    //ABRIRA UN SOCKET EN EL PUERTO 1112 AL QUE SE CONECTARA EL CLIENTE
    //EL CLIENTE NOS ENVIA UN DATAGRAMA QUE SERA UN TEXTO EN EL CUAL COMPROBAMOS SI HA USADO ALGUNA NUESTRAS PALABRAS CLAVES
    //SI HA UTILIZADO ALGUNA LES MANDAMOS AYUDA, Y REDIRIGIMOS AL MAS IDONEO
    //BOMBEROS 1091, POLiCIA 1092, HOSPITAL 1093
    //SI NO HA INCLUIDO NINGUNA PALABRA CLAVE ENVIAREMOS A LA POLICIA  con el puerto 1092
    @Override
    public void run() {
        try {
            DatagramPacket datagrama;
            byte[] mensajeBytes = new byte[1024];
            System.out.println("Servidor.Consola - Se abre un socket servidor en el puerto 1112 de la máquina local");
            int puertoServidor = 1112;
            DatagramSocket socketDatagrama = new DatagramSocket(puertoServidor);

            System.out.println("Servidor.Consola - Esperando a recibir datagrama");
            datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length);
            socketDatagrama.receive(datagrama);

            System.out.println("Servidor.Consola - Mostrando información de datagrama recibido");
            System.out.println(" Servidor.Consola - Mensaje recibido: " + new String(datagrama.getData()));

            System.out.println("\t Servidor.Consola - Construyendo el datagrama a enviar");

            
            //PALABRAS CLAVES
            String palabra = "FUEGO";
            String palabra1 = "BOMBERO";
            String palabra2 = "INCENDIO";
            String palabra3 = "AGUA";
            String palabra4 = "POLICIA";
            String palabra5 = "ROBO";
            String palabra6 = "LADRON";
            String palabra7 = "AGRESION";
            String palabra8 = "HOSPITAL";
            String palabra9 = "CAIDA";
            String palabra10 = "SANGRE";
            String palabra11 = "AMBULANCIA";
            //RECOGEMOS LA DATA DEL DATAGRAMA EN UNA VARIABLE
            String texto = new String(datagrama.getData());
            
            //COMPROBAMOS SI CONTIENE ALGUNA PALABRA CLAVE EL TEXTO QUE NOS MANDAN
            boolean resultado = texto.contains(palabra);
            boolean resultado1 = texto.contains(palabra1);
            boolean resultado2 = texto.contains(palabra2);
            boolean resultado3 = texto.contains(palabra3);
            boolean resultado4 = texto.contains(palabra4);
            boolean resultado5 = texto.contains(palabra5);
            boolean resultado6 = texto.contains(palabra6);
            boolean resultado7 = texto.contains(palabra7);
            boolean resultado8 = texto.contains(palabra8);
            boolean resultado9 = texto.contains(palabra9);
            boolean resultado10 = texto.contains(palabra10);
            boolean resultado11 = texto.contains(palabra11);
            
            //SERIE DE IFs QUE NOS COMUNICAN QUE EQUIPO NOS MANDAN Y MANDAN EL DATAGRAMA DE VUELTA AL CLIENTE
            if (resultado) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos un equipo de BOMBEROS, por el puerto 1091";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado1) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos un equipo de BOMBEROS, por el puerto 1091";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado2) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos un equipo de BOMBEROS, por el puerto 1091";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado3) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos un equipo de BOMBEROS, por el puerto 1091";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado4) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una dotacion de POLICIA, por el puerto 1092";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado5) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una dotacion de POLICIA, por el puerto 1092";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado6) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una dotacion de POLICIA, por el puerto 1092";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado7) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una dotacion de POLICIA, por el puerto 1092";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado8) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una AMBULANCIA, por el puerto 1093";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado9) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una AMBULANCIA, por el puerto 1093";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado10) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una AMBULANCIA, por el puerto 1093";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else if (resultado11) {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una AMBULANCIA, por el puerto 1093";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            } else {
                String mensajeString = "Hola Cliente. Soy el SERVIDOR, Te enviamos una dotacion de POLICIA, por el puerto 1092";
                mensajeBytes = new byte[1024];
                mensajeBytes = mensajeString.getBytes();
                datagrama = new DatagramPacket(mensajeBytes, mensajeBytes.length, datagrama.getAddress(), datagrama.getPort());
                socketDatagrama.send(datagrama);
            }

//            String mensajeString = "Hola Cliente. Soy el SERVIDOR";
//            mensajeBytes = new byte[1024];
//            mensajeBytes = mensajeString.getBytes();
//            
//            
//            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length,datagrama.getAddress(),datagrama.getPort());
//            socketDatagrama.send(datagrama);



//CERRAMOS CONSOLA Y SOCKET
            System.out.println("Servidor.Consola - Cerrando datagrama");
            socketDatagrama.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
