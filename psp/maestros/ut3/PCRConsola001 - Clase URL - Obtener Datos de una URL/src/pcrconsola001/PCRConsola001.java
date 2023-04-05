package pcrconsola001;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * En esta clase se muestra cómo obtener información de una URL
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola001 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        System.out.println("Obteniendo los datos una URL:");
        try {
            URL url = new URL("http://127.0.0.1:8080/apex/f?p=4950:1:4227290199698812");
            System.out.println("\t getProtocol: " + url.getProtocol());
            System.out.println("\t getHost: " + url.getHost());
            System.out.println("\t getPath: " + url.getPath());
            System.out.println("\t getFile: " + url.getFile());
            System.out.println("\t getAuthority: " + url.getAuthority());
            System.out.println("\t getUserInfo: " + url.getUserInfo());
            System.out.println("\t getRef: " + url.getRef());
            System.out.println("\t getQuery: " + url.getQuery());
            System.out.println("\t toExternalForm: " + url.toExternalForm());
            System.out.println("\t toString: " + url.toString());
            System.out.println("\t getDefaultPort: " + url.getDefaultPort());
            System.out.println("\t getPort: " + url.getPort());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
