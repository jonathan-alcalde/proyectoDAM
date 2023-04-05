package pmhconsola400;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * En esta clase se muestra cómo crear un executor service y asignarle tareas
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class PmhConsola400 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) throws InterruptedException {
        //Instanciamos el servicio encargado de procesar las tareas
        ExecutorService servicio = Executors.newCachedThreadPool();
        
        //Descripción de los tipos comunes
        //newCachedThreadPool -> crea y destruye hilos segun la demanda de recursos, 
        //antes de destruir un hilo se espera un tiempo por si fuera posible reciclarlo        
        //newFixedThreadPool -> crea un servicio con un numero fijo de hilos
        //ExecutorService servicio = Executors.newFixedThreadPool(3);
        //newSingleThreadExecutor -> crea un servicio con un unico hilo
        //ExecutorService servicio = Executors.newSingleThreadExecutor();
        //newWorkStealingPool -> crea pools de hilos independientes a la aplicación
        //ExecutorService servicio = Executors.newWorkStealingPool();
        
        //Instanciamos 4 tareas
        Tarea t1 = new Tarea("Tarea1",10, 350);
        Tarea t2 = new Tarea("Tarea2",10, 300);
        Tarea t3 = new Tarea("Tarea3",10, 250);
        Tarea t4 = new Tarea("Tarea4",10, 200);
        
        System.out.println("Arrancamos las tareas");
        
        //Asignamos las tareas al servicio para que las procese
        servicio.submit(t1);
        servicio.submit(t2);
        servicio.submit(t3);
        servicio.submit(t4);
        
        //Si no apagamos el servicio la aplicación no termina la ejecución
        //El método shutdown() impide la recepcion de nuevas tareas y una vez 
        //concluidas las existente termina el servicio
        servicio.shutdown();        
        System.out.println("Termina el hilo principal");        
    }    
}
