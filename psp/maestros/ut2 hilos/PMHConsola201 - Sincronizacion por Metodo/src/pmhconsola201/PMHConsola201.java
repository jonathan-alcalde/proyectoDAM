package pmhconsola201;

/**
 * En esta clase se muestra cómo implementar una sección crítica alrededor de un método
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola201 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Almacen a = new Almacen(100);
        
        Hilo h1 = new Hilo(a, 50);
        h1.start();
        
        Hilo h2 = new Hilo(a, 40);
        h2.start();

        Hilo h3 = new Hilo(a, 30);
        h3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        Hilo h4 = new Hilo(a, 20);
        h4.start();
    }
    
}
