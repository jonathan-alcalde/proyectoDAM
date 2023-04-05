package pmhconsola000;

/**
 * En esta clase se muestra cómo crear e iniciar hilos
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola000 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",300,50);
        h1.start();
        Hilo h2 = new Hilo("Ana",200,75);
        h2.start();
        Hilo h3 = new Hilo("Luis",100,100);
        h3.start();
    }
    
}
