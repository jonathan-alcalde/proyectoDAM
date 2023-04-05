package pmhconsola400;

/**
 * En esta clase implementa la interfaz runnable que partiendo de un valor inicial que se carga 
 * en un contador, va decrementando dicho contador sucesivamente, uno a uno, mostrando cada nuevo
 * valor y realizando una pausa cada vez que se produce un decremento en dicho contador
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class Tarea implements Runnable {
    private String descripcion;
    private int longitudPausa;
    private int iteraciones;

    /**
     * Constructor de la clase, permite definir las distintas propiedades que determinaran
     * el tiempo de ejecución de la la tarea.
     * @param descripcion Descripción de la tarea
     * @param iteraciones Valor inicial del contador
     * @param longitudPausa Longuitud de la pausa cada vez que se decrementa el contador
     */
    public Tarea(String descripcion, int iteraciones, int longitudPausa){
        this.descripcion = descripcion;
        this.iteraciones = iteraciones;
        this.longitudPausa = longitudPausa;
    }
    
    /**
     * Método que implementa el comportamiento de la tarea. Realiza las siguientes acciones mientras el
     * contador es mayor o igual que 0:
     * 1. Muestra el valor actual del contador
     * 2. Hiberna el hilo durante el tiempo especificado en el atributo longitudPausa
     * 3. Decrementa el contador
     */
    @Override
    public void run() {
        try {
            while(iteraciones > 0){                            
                String nombreHilo = Thread.currentThread().getName();
                System.out.println(descripcion+":"+nombreHilo+":"+iteraciones);
                Thread.sleep(longitudPausa);
                iteraciones -= 1;
            }        
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
  
}
