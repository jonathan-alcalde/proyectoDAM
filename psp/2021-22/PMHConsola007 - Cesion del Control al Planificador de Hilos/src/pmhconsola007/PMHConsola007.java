package pmhconsola007;

/**
 * En esta clase se muestra cómo ceder el control al planificador de hilos
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola007 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",40,50);
        h1.start();
        
        Hilo h2 = new Hilo("Ana",200,75);
        h2.setPriority(10);
        h2.start();
        
        Hilo h3 = new Hilo("Luis",100,100);
        h3.start();
    }
    
}
