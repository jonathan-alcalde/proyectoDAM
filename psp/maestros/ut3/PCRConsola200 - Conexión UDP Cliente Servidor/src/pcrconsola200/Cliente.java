package pcrconsola200;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Esta clase implementa un hilo que establece conexión con un servidor, le envía un mensaje a dicho
 * servidor, recibe un mensaje del mismo servidor y muestra este mensaje por consola
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Cliente extends Thread {
    
    String nombre;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run() {
        try {
            DatagramPacket datagrama;
            byte[] mensajeBytes = new byte[1024];
            int puertoCliente = 45000;
            DatagramSocket socketDatagrama = new DatagramSocket(puertoCliente);

            System.out.println("\t Cliente.Consola - Construyendo el datagrama a enviar");
            InetAddress servidor = InetAddress.getLocalHost();
            int puertoServidor = 30500;
            String mensajeString = "Hola Servidor. Soy " + nombre;
            mensajeBytes = mensajeString.getBytes();
            
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length,servidor,puertoServidor);
            socketDatagrama.send(datagrama);
            
            System.out.println("\t Cliente.Consola - Esperando a recibir datagrama");
            mensajeBytes = new byte[1024];
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length);
            socketDatagrama.receive(datagrama);
            
            System.out.println("\t Cliente.Consola - Mostrando información de datagrama recibido");
            System.out.println("\t  Cliente.Consola - Mensaje recibido: " + new String(datagrama.getData()));
            System.out.println("\t  Cliente.Consola - Equipo cliente: " + datagrama.getAddress().getHostAddress());
            System.out.println("\t  Cliente.Consola - Puerto cliente: " + datagrama.getPort());
            System.out.println("\t  Cliente.Consola - Longitud del mensaje: " + datagrama.getData().length);
            
            System.out.println("\t Cliente.Consola - Cerrando datagrama");
            socketDatagrama.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

}
