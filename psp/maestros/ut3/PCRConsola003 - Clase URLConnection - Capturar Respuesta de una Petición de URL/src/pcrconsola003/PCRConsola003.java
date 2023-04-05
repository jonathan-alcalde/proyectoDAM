package pcrconsola003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * En esta clase se muestra cómo capturar la respuesta de una petición de URL
 * usando la clase URLConnection
 *
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
 */
public class PCRConsola003 {

    /**
     * Método principal de la clase
     *
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) {
        System.out.println("Obteniendo la respuesta de una Conexión URL:");
        try {
            URL url = new URL("https://crunchify.com/wp-content/uploads/code/json.sample.txt");
            URLConnection conexionURL = url.openConnection();

            if (conexionURL != null) {
                conexionURL.setReadTimeout(1000); //establecemos un timeout
            }
            else return; //fallo en la conexión
            
            InputStream is = conexionURL.getInputStream();
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
