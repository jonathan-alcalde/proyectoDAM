package pmhconsola001;

/**
 * En esta clase se muestra cómo obtener información de un hilo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola001 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creación del Hilo");
        Hilo h1 = new Hilo("Pepe",25,50);
        System.out.println("Ejecución del Hilo");
        h1.start();
        System.out.println("¿El Hilo está vivo? " + h1.isAlive());
        System.out.println("¿El Hilo está interrumpido? " + h1.isInterrupted());
        h1.interrupt();
        System.out.println("¿El Hilo está interrumpido? " + h1.isInterrupted());
        System.out.println("¿El Hilo está vivo? " + h1.isAlive());
        System.out.println("Información del Hilo: " + h1.toString());
        System.out.println("Identificador del Hilo: " + h1.getId());
        System.out.println("Nombre del Hilo: " + h1.getName());
        System.out.println("Prioridad del Hilo: " + h1.getPriority());
        System.out.println("¿El Hilo está interrumpido? " + h1.isInterrupted());
        Thread.sleep(1000);
        System.out.println("¿El Hilo está interrumpido? " + h1.isInterrupted());
    }
    
}
