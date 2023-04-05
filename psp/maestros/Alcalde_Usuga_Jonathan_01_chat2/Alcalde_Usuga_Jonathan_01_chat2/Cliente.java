package Alcalde_Usuga_Jonathan_01_chat2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente implements Runnable {
    private Socket cliente;
    private BufferedReader in;
    private PrintWriter out;
    private boolean hecho;
    

    @Override
    public void run() {
        try {
            cliente = new Socket("192.168.1.133",9999);
            out = new PrintWriter(cliente.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

      
            ManejadorDeEntradas inHandler = new ManejadorDeEntradas();
            Thread t = new Thread(inHandler);
            t.start();

            String inMensaje;
            while((inMensaje = in.readLine()) != null) {
                System.out.println(inMensaje);
            }
        }
        catch(IOException e) {
            cerrarConexion();
        }
    }
    //Método que cierra la conexión del cliente con el servidor
    public void cerrarConexion() {
        hecho  = true;
        try {
            in.close();
            out.close();
            if(!cliente.isClosed()) {
                cliente.close();
            }
        }
        catch(IOException e) {
            //No se puede manejar la excepcion
        }


    }
    
    //Clase que se ejecutará junto al cliente para pedirle que introduzca datos por consola y sean enviados al servidor
    class ManejadorDeEntradas implements Runnable{
        @Override
        public void run() {
            try {
                BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
                while(!hecho) {
                    if(!hecho) {
                        String mensaje = lector.readLine();
                        if(mensaje.equals("/quit")) {
                            lector.close();
                            cerrarConexion();
                        }
                        else {
                            out.println(mensaje);
                        }
                    }

                }
            } catch(IOException e) {
                cerrarConexion();
            }
        }
    }
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.run();
    }
}
