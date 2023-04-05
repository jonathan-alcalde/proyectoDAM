package pmhconsola201;

/**
 * Esta clase implementa un hilo que se encarga de extraer una cantidad determinada de piezas 
 * de un determinado almacén
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Hilo extends Thread {
    Almacen almacen;
    int cantidadPiezas;

    /**
     * Constructor que pèrmite inicializar el hilo con la cantidad de piezas a extraer y el almacén 
     * del que hacerlo
     * @param almacen Almacén del que extraer las piezas
     * @param cantidadPiezas Cantidad de piezas a extraer
    */
    public Hilo(Almacen almacen, int cantidadPiezas) {
        this.almacen = almacen;
        this.cantidadPiezas = cantidadPiezas;
    }

    
    /**
     * Método que implementa el comportamiento del hilo. Extrae la cantidad de piezas indicadas en el
     * atributo cantidadPiezas del almacén indicado en el atributo almacen
    */
    @Override
    public void run() {
        int piezasRestantes;
        System.out.println("Sacando " + cantidadPiezas + " piezas del almacen ...");
        piezasRestantes = almacen.sacarPiezas(cantidadPiezas);
        if (piezasRestantes != -1) {
            System.out.println(cantidadPiezas + " piezas extraídas. Quedan " + piezasRestantes + " en el almacen.");
        } else {
            System.out.println("Imposible sacar " + cantidadPiezas + " piezas. Solo quedan " + almacen.getCantidadPiezasAlmacenadas() + " piezas.");
        }
    }
    
}
