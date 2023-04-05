package pmhconsola201;

/**
 * Clase que representa un almacén en el que se almacena una cantidad de piezas
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Almacen {
    int cantidadPiezasAlmacenadas;

    /**
     * Constructor que inicializa el almacén con una cantidad de piezas
     * @param cantidadPiezasAlmacenadas Cantidad de piezas inicial en el almacén
    */
    public Almacen(int cantidadPiezasAlmacenadas) {
        this.cantidadPiezasAlmacenadas = cantidadPiezasAlmacenadas;
    }

    /**
     * Método que devuelve la cantidad de piezas actual en el almacén
     * @return  Cantidad actual de piezas en el almacén
    */
    public int getCantidadPiezasAlmacenadas() {
        return cantidadPiezasAlmacenadas;
    }

    /**
     * Método que resta una cantidad la cantidad de piezas actual en el almacén
     * @param cantidadPiezas Cantidad de piezas a sacar del almacén
     * @return  Cantidad restante de piezas en el almacén o -1 si no hay piezas suficientes
    */
    synchronized public int sacarPiezas(int cantidadPiezas) {
        if (cantidadPiezas <= cantidadPiezasAlmacenadas) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            cantidadPiezasAlmacenadas = cantidadPiezasAlmacenadas - cantidadPiezas;
            return cantidadPiezasAlmacenadas;
        } else {
            return -1;
        }
    }

}
