package pmpconsola101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * En esta clase se muestra:
 *  1. Cómo interactuar con una clase Java
 * Para poder ejecutar este proyecto será necesario que existan las siguientes variables de entorno:
 *  1. PATH con la ubicación del programa java.exe
 *  2. CLASSPATH con la ubicación del fichero Pregunta.class
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola101 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "java Pregunta";
        Process proceso;
        try {
            System.out.println("Lanzando el programa Java");
            proceso = r.exec(comando);
            OutputStream os = proceso.getOutputStream();
            os.write("Ignacio\n".getBytes());
            os.flush();
            InputStream is = proceso.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
