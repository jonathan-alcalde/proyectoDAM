package pmhconsola401;

import java.util.concurrent.Callable;

/**
 * Esta clase implementa la interfaz Callable<Integer> la cual calcula el 
 * factorial del número indicado. Se incluye una pausa en cada iteración con 
 * el fin de ralentizar la ejecución.
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class Tarea implements Callable<Integer> {
    public int numero;
    private int longitudPausa = 200;
    
    /**
     * Constructor de la clase.
     * @param numero Indica el número al que se va a calcular el factorial.
     */
    public Tarea(int numero){
        this.numero = numero;         
    } 
            
    /**
     * Método que implementa el comportamiento de la tarea. Realiza las siguienes acciones:
     * 1. Define la variable resultado con valor 1
     * 2. Desde indice igual 2 hasta el valor de numero
     * 2.1. Muestro informacion del hilo
     * 2.2. Resultado es igual a resultado por indice
     * 2.3. Hiberno el hilo
     * 3. Devuelvo resultado
     * @return Devuelve el factorial de numero
     * @throws Exception
     */
    @Override
    public Integer call() throws InterruptedException {
        int resultado = 1;
        for(int i=2; i<=this.numero;++i){
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("Factorial["+this.numero+"]:"+nombreHilo+":"+i+":"+resultado);
            resultado = resultado * i;            
            Thread.sleep(this.longitudPausa);
        }
        return resultado;
    }
    
}
