package pcrconsola101;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Clase que implementa un hilo que gestiona la recepción del mensaje de un cliente, el envío del mensaje
 * a dicho cliente y la muestra del mensaje recibido por consola
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class SesionServidor extends Thread {
    
    Socket clienteConectado;
    
    public SesionServidor(Socket clienteConectado) {
        this.clienteConectado = clienteConectado;
    }
    
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run () {
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
