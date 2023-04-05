package pmhconsola002;

/**
 * En esta clase se muestra cómo establecer el nombre y prioridad de un hilo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola002 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Pepe",400,0);
        h1.setName("Pepe");
        h1.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Iniciando el hilo " + h1.toString());
        h1.start();

        Hilo h2 = new Hilo("Ana",200,0);
        h2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Iniciando el hilo " + h2.toString());
        h2.start();
        
        Hilo h3 = new Hilo("Luis",1000,0);
        h3.setName("Luis");
        h3.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Iniciando el hilo " + h3.toString());
        h3.start();
    }
    
}
