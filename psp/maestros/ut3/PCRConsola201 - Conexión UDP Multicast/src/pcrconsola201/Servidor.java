package pcrconsola201;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Servidor extends Thread {
    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Servidor.Consola - Dime el mensaje a enviar a todos los clientes: ");
        String mensaje = teclado.nextLine();
        
        System.out.println(mensaje);
        
        try {
            String direccionGrupoMulticast = "225.8.8.8";
            InetAddress grupoMulticast = InetAddress.getByName(direccionGrupoMulticast);
            int puertoGrupoMulticast = 35000;
            MulticastSocket ms = new MulticastSocket();
            DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.length(),grupoMulticast,puertoGrupoMulticast);
            ms.send(datagrama);
            ms.close();
        } catch (IOException ex) {
        }
        
        
    }
}
