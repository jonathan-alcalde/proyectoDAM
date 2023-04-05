package pcrconsola000;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * En esta clase se muestra cómo obtener información de un equipo local o remoto
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola000 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        System.out.println("Obteniendo los datos del equipo local:");
        try {
            InetAddress dir = InetAddress.getByName("localhost");
            System.out.println("\t toString de un objeto InetAddress: " + dir.toString());
            System.out.println("\t getCanonicalHostName de un objeto InetAddress: " + dir.getCanonicalHostName());
            System.out.println("\t getHostAddress de un objeto InetAddress: " + dir.getHostAddress());
            System.out.println("\t getHostName de un objeto InetAddress: " + dir.getHostName());
            System.out.println("\t getAddress de un objeto InetAddress: " + dir.getAddress()[0] + "-" + dir.getAddress()[1] + "-" + dir.getAddress()[2] + "-" + dir.getAddress()[3]);
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Obteniendo todas las IP de yahoo:");
        try {
            InetAddress[] dirs = InetAddress.getAllByName("www.yahoo.es");
            int cont = 0;
            while (cont < dirs.length) {
                System.out.println("\t Dirección " + cont + ": " + dirs[cont].getHostAddress());
                cont++;
            }
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
