package pcrconsola102;

/**
 * En esta clase se crean dos hilos (un hilo cliente y un hilo servidor) y se inician. El hilo cliente
 * establece conexión TCP con el servidor y realiza las siguientes actuaciones:
 * 1. El cliente construye un objeto Coche y lo envía al servidor
 * 2. El servidor muestra por consola el objeto recibido
 * 3. El servidor responde al cliente con el mismo objeto recibido incrementando en 1 el número de puertas.
 * 4. El cliente muestra por consola dicho objeto
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola102 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Thread servidor = new Servidor();
        Thread cliente = new Cliente("PEPE");
        
        servidor.start();
        cliente.start();
    }
    
}
