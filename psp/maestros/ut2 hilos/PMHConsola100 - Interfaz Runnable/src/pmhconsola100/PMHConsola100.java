package pmhconsola100;

/**
 * En esta clase se muestra cómo lanzar un hilo que se ha definido a través de la interfaz runnable
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola100 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        HijoHilo hh = new HijoHilo(18);
        Thread h1 = new Thread(hh);
        h1.start();
    }
    
}
