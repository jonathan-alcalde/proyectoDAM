package pmpconsola000;

import java.io.IOException;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar un ejecutable de windows y continuar con el programa
 *  2. Cómo lanzar un ejecutable de windows y esperar a que termine
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola000 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando1 = "notepad";
        String comando2 = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe";// "C:\\Program Files\\Microsoft Office\\Office12\\excel";
        String comando3 = "C:\\Program Files\\DAEMON Tools Lite\\DTLite.exe";
        Process proceso;
        try {
            System.out.println("Lanzando el NOTEPAD");
            proceso = r.exec(comando1);
            System.out.println("El NOTEPAD está corriendo pero el programa sigue");

            System.out.println("Lanzando el EXCEL");
            proceso = r.exec(comando2);
            System.out.println("Esperando a que termine la ejecución de EXCEL ...");
            int resultado = proceso.waitFor();
            if (resultado == 0) {
                System.out.println("EXCEL ha finalizado correctamente");
            } else {
                System.out.println("ERROR en la ejecución de EXCEL !!!");
            }
            proceso = r.exec(comando3);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
