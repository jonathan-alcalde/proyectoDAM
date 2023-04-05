package pcrconsola200;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Esta clase implementa un hilo que permite 2 conexiones de cliente. En cada conexión, recibe un
 * mensaje del cliente, lo muestra por consola y envía un mensaje a dicho cliente
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Servidor extends Thread {
    
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run () {
        try {
            DatagramPacket datagrama;
            byte[] mensajeBytes = new byte[1024];
            System.out.println("Servidor.Consola - Se abre un socket servidor en el puerto 30500 de la máquina local");
            int puertoServidor = 30500;
            DatagramSocket socketDatagrama = new DatagramSocket(puertoServidor);

            System.out.println("Servidor.Consola - Esperando a recibir datagrama");
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length);
            socketDatagrama.receive(datagrama);
            
            System.out.println("Servidor.Consola - Mostrando información de datagrama recibido");
            System.out.println(" Servidor.Consola - Mensaje recibido: " + new String(datagrama.getData()));
            System.out.println(" Servidor.Consola - Equipo cliente: " + datagrama.getAddress().getHostAddress());
            System.out.println(" Servidor.Consola - Puerto cliente: " + datagrama.getPort());
            System.out.println(" Servidor.Consola - Longitud del mensaje: " + datagrama.getData().length);

            System.out.println("\t Servidor.Consola - Construyendo el datagrama a enviar");
            String mensajeString = "Hola Cliente. Soy el SERVIDOR";
            mensajeBytes = new byte[1024];
            mensajeBytes = mensajeString.getBytes();
            
            
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length,datagrama.getAddress(),datagrama.getPort());
            socketDatagrama.send(datagrama);

            
            System.out.println("Servidor.Consola - Cerrando datagrama");
            socketDatagrama.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
