package pmpconsola201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar comandos internos de MSDOS con ProcessBuilder
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola201 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        try {
            pb.command("cmd","/c","dir");
            Process proceso = pb.start();
            System.out.println("DIR se lanzó con éxito");
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
                System.out.println("ERROR en la ejecución de DIR !!!");
        }
        try {
        } catch (Exception ex) {
            System.out.println("ERROR en la ejecución de DIR !!!");
        }
    }
    
}
