package pmhconsola006;

/**
 * Esta clase implementa un hilo que partiendo de un valor inicial que se carga en un contador, va
 * decrementando dicho contador sucesivamente, uno a uno, mostrando cada nuevo valor y realizando una
 * pausa cada vez que se produce un decremento en dicho contador. Además, incorpora la posiblidad de
 * indicar que la ejecución del presente hilo no se lleve a cabo hasta la finalización de un hilo previo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Hilo extends Thread {
    String nombre;
    int cont;
    int longitudPausa;
    Thread hiloPrevio;
    
    /**
     * Constructor que pèrmite inicializar el hilo con el nombre del hilo, el valor con el que se 
     * incializa el contador y la longitud de la pausa a realizar en cada decremento del contador. El
     * constructor informa además de dicha inicialización por consola
     * @param nombre Nombre del hilo
     * @param cont Valor inicial del contador
     * @param longitudPausa Longitud de la pausa a realizar cada vez que se decrementa el contador
    */
    public Hilo(String nombre, int cont, int longitudPausa) {
        this.nombre = nombre;
        this.cont = cont;
        this.longitudPausa = longitudPausa;
        this.hiloPrevio = null;
        System.out.println("Creando el hilo " + nombre);
    }
    
    /**
     * Constructor que pèrmite inicializar el hilo con el nombre del hilo, el valor con el que se 
     * incializa el contador, la longitud de la pausa a realizar en cada decremento del contador, y
     * cuál es el hilo cuya finalización es necesario esperar para poder continuar. El constructor 
     * informa además de dicha inicialización por consola
     * @param nombre Nombre del hilo
     * @param cont Valor inicial del contador
     * @param longitudPausa Longitud de la pausa a realizar cada vez que se decrementa el contador
     * @param hiloPrevio Hilo a cuya finalización hay que esperar antes de la ejecución del presente hilo
    */
    public Hilo(String nombre, int cont, int longitudPausa, Thread hiloPrevio) {
        this.nombre = nombre;
        this.cont = cont;
        this.longitudPausa = longitudPausa;
        this.hiloPrevio = hiloPrevio;
        System.out.println("Creando el hilo " + nombre);
    }
    
    /**
     * Método que implementa el comportamiento del hilo. Comprueba si el hilo actual tiene definido un 
     * hilo previo. De ser así pone el presente hilo a la espera de que el hilo previo termine.
     * Una vez que dicho hilo haya terminado o si no existiera dicho hilo previo, raliza las siguientes
     * acciones mientras el contador es mayor o igual que 0:
     * 1. Muestra el valor actual del contador
     * 2. Hiberna el hilo durante el tiempo especificado en el atributo longitudPausa
     * 3. Decrementa el contador
    */
    @Override
    public void run() {
        if (hiloPrevio != null) {
            try {
                hiloPrevio.join();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
        while (cont >= 0) {
            System.out.println(nombre + ": " + cont);
            try {
                Thread.sleep(longitudPausa);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            cont = cont - 1;
        }
    }
    
}
