package pcrconsola202;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Esta clase implementa un hilo que recibe una conexión UDP de cliente. En dicha conexión, recibe un
 * objeto Coche del cliente, lo muestra por consola, le incrementa en 1 la cantidad de puertas y lo 
 * devuelve al cliente
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
            System.out.println("Servidor.Consola - Se abre un socket UDP en el puerto 30500 de la máquina local");
            int puertoServidor = 30500;
            DatagramSocket socketDatagrama = new DatagramSocket(puertoServidor);

            System.out.println("Servidor.Consola - Esperando a recibir datagrama");
            byte[] mensajeBytes = new byte[1024];
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length);
            socketDatagrama.receive(datagrama);
            ByteArrayInputStream bais = new ByteArrayInputStream(mensajeBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Coche coche = (Coche) ois.readObject();
            
            System.out.println("Servidor.Consola - Objeto recibido: " + coche.toString());

            System.out.println("Servidor.Consola - Construyendo el datagrama a enviar");
            coche.setCantidadPuertas(coche.getCantidadPuertas() + 1);
            
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(coche);
            mensajeBytes = baos.toByteArray();
            datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length,datagrama.getAddress(),datagrama.getPort());
            socketDatagrama.send(datagrama);
            
            System.out.println("Servidor.Consola - Cerrando datagrama y streams");
            socketDatagrama.close();
            oos.close();
            baos.close();
            ois.close();
            bais.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
