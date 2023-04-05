package pmhconsola404;

/**
 * En esta clase implementa la interfaz runnable que partiendo de un valor inicial que se carga 
 * en un contador, va decrementando dicho contador sucesivamente, uno a uno, mostrando cada nuevo
 * valor y realizando una pausa cada vez que se produce un decremento en dicho contador
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class Tarea implements Runnable {

    public String descripcion;
    public int longitudPausa;
    public int contador = 0;

    /**
     * Constructor de la clase.
     * @param descripcion Descripción de la tarea
     * @param longitudPausa Longitud de las pausas
     */
    public Tarea(String descripcion, int longitudPausa) {
        this.descripcion = descripcion;
        this.longitudPausa = longitudPausa;
    }

    /**
     * Método que implementa el comportamiento de la tarea. Realiza las siguientes acciones:
     * 1. Incrementa el contador de ejecuciones
     * 2. Imprime la información del hijo junto con el número de ejecuciones     
     * 3. Hiberna el hilo el tiempo indicado por longitudPausa
     */
    @Override
    public void run() {
        try {
            ++this.contador;
            String nombreHilo = Thread.currentThread().getName();
            System.out.println(this.descripcion + ":" + nombreHilo + ":" + this.contador);
            Thread.sleep(this.longitudPausa);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
