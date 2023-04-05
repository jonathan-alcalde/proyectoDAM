package pmhconsola100;

/**
 * Esta clase implementa un hilo que lo único que hace es mostrar por consola el valor de su atributo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class HijoHilo extends Padre implements Runnable {
    
    /**
     * Constructor que pèrmite asignar un valor al atributo a
     * @param a Atributo de la clase
    */
    HijoHilo(int a) {
        super(a);
    }
    
    /**
     * Método que implementa el comportamiento del hilo. Simplemente muestra por consola el valor del
     * atributo a
    */
    @Override
    public void run() {
        System.out.println("El valor de a es: " + a);
    }
    
}
