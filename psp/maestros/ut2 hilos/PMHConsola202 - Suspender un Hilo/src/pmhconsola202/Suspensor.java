package pmhconsola202;

/**
 * Esta clase implementa una simulación de suspensión de hilos. Todo hilo que necesite ser 
 * suspendido (y resumido) podrá utilizar un objeto de esta clase
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Suspensor {
    private boolean suspendido;
          

    /**
     * Constructor que pèrmite inicializar el hilo con el nombre del hilo, el valor con el que se 
     * incializa el contador y la longitud de la pausa a realizar en cada decremento del contador. El
     * constructor informa además de dicha inicialización por consola
     * @return True si debe entrarse o continuar en estado de suspensión, false en caso contrario
    */
    public boolean isSuspendido() {
        return suspendido;
    }

    /**
     * Método que permite establecer si se desea suspender un hilo o si se desea resumir
     * @param suspendido true si se desea suspender el hilo o false si se desea resumir
    */
    synchronized public void setSuspendido(boolean suspendido) {
        this.suspendido = suspendido;
        notifyAll();
    }
    
    /**
     * Este método se mantiene en un bucle mientras debe continuar la suspensión. En cada iteración
     * del bucle se realiza un wait
     * @throws InterruptedException en el caso de que wait sufra una excepción
    */
    synchronized public void esperarAResumir () throws InterruptedException {
        while (suspendido) {
            wait();
        }
    }
}
