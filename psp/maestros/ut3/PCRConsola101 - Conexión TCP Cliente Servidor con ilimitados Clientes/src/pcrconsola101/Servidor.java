package pcrconsola101;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Esta clase implementa un hilo que permite ilimitadas conexiones de cliente. Por cada conexión se crea
 * un hilo que gestiona la comunicación con dicho cliente
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
            System.out.println("Servidor.Consola - Se abre un socket servidor en el puerto 30500 de la máquina local");
            int puertoServidor = 30500;
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            
            System.out.println("Servidor.Consola - Se crea un ArrayList para almacenar los manejadores de sockets de los clientes");
            ArrayList<SesionServidor> sesiones = new ArrayList();
            System.out.println("Servidor.Consola - El servidor queda a la espera indefinidamente de todas las conexiones de cleinte que se produzcan");
            Socket clienteConectado;
            SesionServidor sesion;
            while (true) {
                clienteConectado = socketServidor.accept();
                sesion = new SesionServidor(clienteConectado);
                sesiones.add(sesion);
                sesion.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
