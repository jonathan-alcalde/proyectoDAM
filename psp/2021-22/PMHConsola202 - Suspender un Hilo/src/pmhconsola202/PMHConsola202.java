package pmhconsola202;

/**
 * En esta clase se muestra cómo suspender y resumir un hilo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola202 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",50,100);
        System.out.println("Iniciando el hilo " + h1.toString());
        h1.start();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        h1.suspender();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        h1.resumir();
    }
    
}
