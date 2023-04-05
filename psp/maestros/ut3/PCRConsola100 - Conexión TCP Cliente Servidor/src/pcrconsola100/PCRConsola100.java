package pcrconsola100;

/**
 * En esta clase se crean tres hilos (dos hilo cliente y un hilo servidor) y se inician. Cada uno de
 * los hilos cliente establece conexión con el servidor y realiza las siguientes actuaciones:
 * 1. El cliente envía un mensaje al servidor
 * 2. El servidor muestra por consola dicho mensaje
 * 3. El servidor responde con otro mensaje al cliente.
 * 4. El cliente muestra por consola dicho mensaje
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola100 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Thread servidor = new Servidor();
        Thread cliente1 = new Cliente("PEPE");
        Thread cliente2 = new Cliente("LUIS");
        
        servidor.start();
        cliente1.start();
        cliente2.start();
    }
    
}
