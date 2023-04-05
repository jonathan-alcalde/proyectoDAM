package pcrconsola100;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("Servidor.Consola - Se abre un socket servidor en el puerto 30500 de la máquina local");
            int puertoServidor = 30500;
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            
            System.out.println("Servidor.Consola - El servidor se queda a la espera de algún cliente establezca conexión con el servidor");
            Socket clienteConectado1 = socketServidor.accept();
            gestionarDialogo(clienteConectado1);
            
            System.out.println("Servidor.Consola - El servidor se queda a la espera de algún cliente establezca conexión con el servidor");
            Socket clienteConectado2 = socketServidor.accept();
            gestionarDialogo(clienteConectado2);
            
            clienteConectado1.close();
            clienteConectado2.close();
            socketServidor.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Método que implementa la recepción del mensaje del cliente, el envío del mensaje a dicho
     * cliente y la muestra del mensaje recibido por consola
     * @param clienteConectado Socket que se usa para realizar la comunicación con el cliente
    */
    public void gestionarDialogo(Socket clienteConectado) {
        try {
            System.out.println("Servidor.Consola - El servidor ha recibido un mensaje de algún cliente y procede a mostrarlo por consola");
            InputStream is;
            is = clienteConectado.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println("Servidor.Consola - Mensaje recibido del Cliente: " + dis.readUTF());
            
            System.out.println("Servidor.Consola - El servidor responde al cliente");
            OutputStream os = clienteConectado.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("HOLA CLIENTE");
            
            is.close();
            dis.close();
            os.close();
            dos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
