package pmhconsola402;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * En esta clase se muestra cómo trabajar con los distintos métodos que aporta la 
 * clase Future. Mediante una serie de ejemplos se muestra como comprobar si la tarea 
 * esta completada o cancelada, como cancelar una tarea, asi como leer resultados con 
 * y sin tiempos de espera.
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class PmhConsola402 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Instanciamos el servicio encargado de procesar las tareas
        ExecutorService servicio = Executors.newCachedThreadPool();

        //Instanciamos una tarea y se la asignamos al servicio.
        Tarea definicionTarea = new Tarea(4, 1000);
        Future<String> resultadoFuturo = servicio.submit(definicionTarea);

        System.out.println("Primera tarea");
        //Comprobamos si la tarea esta completada
        System.out.println("¿La tarea ha concluido? " + resultadoFuturo.isDone());
        //Comprobamos si la tarea esta cancelada
        System.out.println("¿La tarea ha sido cancelada? " + resultadoFuturo.isCancelled());

        String resultado = null;
        try {
            //Tratamos de leer el resultado de la tarea estableciendo un tiempo de espera
            resultado = resultadoFuturo.get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException ex) {
            System.out.println("Excepcion: Get con tiempo de espera agotado, resultado: " + resultado);
        }
        System.out.println("Resultado con get no bloqueante antes de acabar: " + resultado);
        System.out.println("¿La tarea ha concluido? " + resultadoFuturo.isDone());

        //Leemos el resultado, esta vez esperamos a que la tarea se complete
        resultado = resultadoFuturo.get();
        System.out.println("Resultado con get bloqueante: " + resultado);
        System.out.println("¿La tarea ha concluido? " + resultadoFuturo.isDone());
        System.out.println("¿La tarea ha sido cancelada? " + resultadoFuturo.isCancelled());

        System.out.println("Segunda tarea");
        resultado = null;
        Callable<String> definicionTarea2 = new Tarea(2, 1000);
        Future<String> resultadoFuturo2 = servicio.submit(definicionTarea2);

        System.out.println("¿La tarea 2 ha concluido? " + resultadoFuturo2.isDone());
        System.out.println("¿La tarea 2 ha sido cancelada? " + resultadoFuturo2.isCancelled());

        //cancelamos una tarea pendiente de conclusion
        resultadoFuturo2.cancel(true); //con el parámetro true forzamos el cierre si se esta ejecutando

        System.out.println("¿La tarea 2 ha concluido? " + resultadoFuturo2.isDone());
        System.out.println("¿La tarea 2 ha sido cancelada? " + resultadoFuturo2.isCancelled());

        try {
            //Tratamos de leer el resultado de una tarea cancelada
            resultado = resultadoFuturo2.get();
        } catch (CancellationException ex) {
            System.out.println("Excepcion: Get con tarea cancelada, resultado: " + resultado);
        }

        //Apagamos el servicio
        servicio.shutdown();

        System.out.println("Añadimos una nueva tarea al servicio parado");
        Callable<String> definicionTarea3 = new Tarea(1, 1000);
        Future<String> resultadoFuturo3;
        try {
            //Añadimos una nueva tarea a un servicio apagado
            resultadoFuturo3 = servicio.submit(definicionTarea3);
        } catch (RejectedExecutionException ex) {
            System.out.println("Excepcion: el servicio esta apagado");
        }

        System.out.println("Termina el hilo principal");
    }

}
