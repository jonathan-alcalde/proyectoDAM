package pmhconsola402;

import java.util.concurrent.Callable;

/**
 * Esta clase implementa la interfaz Callable<String> la cual devuelve un 
 * mensaje informativo tras esperar un tiempo.
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class Tarea implements Callable<String>{

    public int iteraciones;
    public int longitudPausa;
    
    /**
     * Constructor de la clase, permite definir las distintas propiedades que determinaran
     * el tiempo de ejecución de la la tarea.
     * @param iteraciones Numero de pausas
     * @param longitudPausa Longitud de las pausas
     */
    public Tarea(int iteraciones, int longitudPausa){
        this.iteraciones = iteraciones;
        this.longitudPausa = longitudPausa;        
    }
    
    /**
     * Método que implementa el comportamiento de la tarea. Realiza las siguientes acciones:
     * 1. Mientras el contador es mayor que indiceActual
     * 1.1 Hiberna el hilo durante el tiempo especificado en el atributo longitudPausa
     * 1.2. Incrementa el contador
     * 2. Devuelve un mensaje indicando el tiempo consumido por la tarea
     * @return
     * @throws InterruptedException 
     */
    @Override
    public String call() throws InterruptedException  {
        int iteracionActual = 0;
        while(iteraciones > iteracionActual){
            Thread.sleep(this.longitudPausa);
            ++iteracionActual;
        }
        return "La tarea a consumido " + (iteracionActual*this.longitudPausa)+ " milisegundos";
    }    
}
