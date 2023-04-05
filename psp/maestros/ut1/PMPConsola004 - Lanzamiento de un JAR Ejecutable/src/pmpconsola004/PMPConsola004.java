package pmpconsola004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar una clase Java
 * Para poder ejecutar este proyecto será necesario:
 *  1. Que exista la variable de entorno PATH con la ubicación del programa java.exe
 *  2. El fichero saludo.jar debe alojarse en el directorio c:\maniobra
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola004 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "java -jar c:\\maniobra\\saludo.jar Ignacio";
        Process proceso;
        try {
            System.out.println("Lanzando el programa Java");
            proceso = r.exec(comando);
            System.out.println("Esperando a que termine la ejecución del programa Java ...");
            int resultado = proceso.waitFor();
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            if (resultado == 0) {
                System.out.println("El programa Java se lanzó con éxito");
                is = proceso.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                System.out.println("ERROR en la ejecución del programa Java !!!");
                is = proceso.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
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
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
