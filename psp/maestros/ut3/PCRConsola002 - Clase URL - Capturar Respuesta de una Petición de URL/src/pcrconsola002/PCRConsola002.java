package pcrconsola002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * En esta clase se muestra cómo capturar la respuesta de una petición de URL usando la clase URL
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola002 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        System.out.println("Obteniendo la respuesta de una URL:");
        try {
//            URL url = new URL("http://127.0.0.1:8080/apex/f?p=4950:1:4227290199698812");
            URL url = new URL("https://crunchify.com/wp-content/uploads/code/json.sample.txt");
            
            
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
