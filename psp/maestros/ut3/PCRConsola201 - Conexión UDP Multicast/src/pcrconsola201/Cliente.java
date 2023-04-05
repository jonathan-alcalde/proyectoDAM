package pcrconsola201;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author usuario
 */
public class Cliente extends Thread {
    String nombre;
    
    public Cliente (String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        byte[] mensajeBytes = new byte[1024];
        try {
            String direccionGrupoMulticast = "225.8.8.8";
            InetAddress grupoMulticast = InetAddress.getByName(direccionGrupoMulticast);
            int puertoGrupoMulticast = 35000;
            MulticastSocket ms = new MulticastSocket(puertoGrupoMulticast);
            ms.joinGroup(grupoMulticast);
            DatagramPacket datagrama = new DatagramPacket(mensajeBytes,mensajeBytes.length);
            ms.receive(datagrama);
            System.out.println("\t Cliente.Consola " + nombre + " - " + new String(datagrama.getData()));
            ms.close();
        } catch (IOException ex) {
        }
    }
}
