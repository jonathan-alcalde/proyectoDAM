package pmhconsola006;

/**
 * En esta clase se muestra cómo secuenciar la ejecución de varios hils
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola006 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",40,50);
        h1.start();
        
        Hilo h2 = new Hilo("Ana",200,75,h1);
        h2.start();
        
        Hilo h3 = new Hilo("Luis",100,100);
        h3.start();
        
        System.out.println("Esperando a que termine el hilo Luis ...");
        try {
            h3.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Hilo Luis terminado");
    }
    
}
