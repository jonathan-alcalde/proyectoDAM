package pmhconsola005;

/**
 * En esta clase se muestra cómo provocar la interrupción de un hilo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola005 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",400,50);
        h1.start();
        
        Hilo h2 = new Hilo("Ana",200,75);
        h2.start();
        
        Hilo h3 = new Hilo("Luis",100,100);
        h3.start();
        
        while (h1.isAlive()) {
            h1.interrupt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
