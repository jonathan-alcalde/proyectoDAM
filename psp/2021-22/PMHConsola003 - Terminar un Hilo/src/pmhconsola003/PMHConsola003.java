package pmhconsola003;

/**
 * En esta clase se muestra cómo finalizar un hilo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola003 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h = new Hilo("Luis",100000,20);
        h.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        h.finalizar();
    }
    
}
