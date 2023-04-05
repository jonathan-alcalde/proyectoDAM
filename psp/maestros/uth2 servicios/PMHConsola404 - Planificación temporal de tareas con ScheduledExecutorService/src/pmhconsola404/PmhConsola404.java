package pmhconsola404;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * En esta clase se muestra cómo trabajar con los Scheduled Executor Services. 
 * Mediante este tipo de servicio podremos establecer una planificación temporal
 * para programar la ejecución de las tareas.
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class PmhConsola404 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) {
        //Instanciamos el servicio, recibe como parametro el número de hilos a instanciar
        ScheduledExecutorService servicio = Executors.newScheduledThreadPool(1);

        Tarea t1 = new Tarea("Me ejecuto una unica vez", 100);
        servicio.schedule(t1, 5000, TimeUnit.MILLISECONDS);

        Tarea t2 = new Tarea("Me ejecuto en un intervalo independiente", 100);
        servicio.scheduleAtFixedRate(
                t2, 
                0 /*demora inicial*/, 
                1000 /*intervalo*/, 
                TimeUnit.MILLISECONDS);

        Tarea t3 = new Tarea("Me ejecuto en un intervalo dependiente", 4000);
        servicio.scheduleWithFixedDelay(
                t3, 
                0 /*demora inicial*/, 
                1000 /*intervalo*/, 
                TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(20000);
            servicio.shutdown();
            servicio.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Excepcion: error al parar alguna tarea");
        } finally {
            if (servicio.isTerminated() == false) {
                System.out.println("Mato las tareas que todavía no se han completado");
                servicio.shutdownNow();
            }
        }
    }

}
