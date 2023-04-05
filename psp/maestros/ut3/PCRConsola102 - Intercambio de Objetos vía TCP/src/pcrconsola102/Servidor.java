package pcrconsola102;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase implementa un hilo que recibe una conexión TCP de cliente. En dicha conexión, recibe un
 * objeto Coche del cliente, lo muestra por consola, le incrementa en 1 la cantidad de puertas y lo 
 * devuelve al cliente
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Servidor extends Thread{
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run() {
        try {
            System.out.println("Servidor.Consola - Se abre un socket servidor en el puerto 30500 de la máquina local");
            int puertoServidor = 30500;
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            
            System.out.println("Servidor.Consola - El servidor se queda a la espera de algún cliente establezca conexión con el servidor");
            Socket clienteConectado = socketServidor.accept();
            gestionarDialogo(clienteConectado);
            
            clienteConectado.close();
            socketServidor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    /**
     * Método que implementa el diálogo con el cliente
     * @param clienteConectado Socket que se usa para realizar la comunicación con el cliente
    */
    public void gestionarDialogo(Socket clienteConectado) {
        try {
            System.out.println("Servidor.Consola - El servidor recibe un objeto Coche del cliente");
            ObjectInputStream ois = new ObjectInputStream(clienteConectado.getInputStream());
            Coche coche = (Coche) ois.readObject();
            System.out.println("Servidor.Consola - Objeto recibido del Cliente: " + coche.toString());
            
            System.out.println("Servidor.Consola - El servidor responde al cliente con el mismo objeto incrementando en 1 el número de puertas");
            coche.setCantidadPuertas(coche.getCantidadPuertas() + 1);
            ObjectOutputStream oos = new ObjectOutputStream(clienteConectado.getOutputStream());
            oos.writeObject(coche);
            
            ois.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
