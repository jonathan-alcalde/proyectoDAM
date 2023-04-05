package pmhconsola001;

/**
 * Esta clase implementa un hilo que partiendo de un valor inicial que se carga en un contador, va
 * decrementando dicho contador sucesivamente, uno a uno, mostrando cada nuevo valor y realizando una
 * pausa cada vez que se produce un decremento en dicho contador
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Hilo extends Thread {
    String nombre;
    int cont;
    int longitudPausa;

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
        System.out.println("Creando el hilo " + nombre);
    }
    
    /**
     * Método que implementa el comportamiento del hilo. Realiza las siguientes acciones mientras el
     * contador es mayor o igual que 0:
     * 1. Muestra el valor actual del contador
     * 2. Hiberna el hilo durante el tiempo especificado en el atributo longitudPausa
     * 3. Decrementa el contador
    */
    @Override
    public void run() {
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
