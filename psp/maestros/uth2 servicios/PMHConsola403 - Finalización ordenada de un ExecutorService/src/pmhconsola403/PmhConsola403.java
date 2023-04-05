package pmhconsola403;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * En esta clase se muestra cómo trabajar con las distintas formas de apagar 
 * un executor service. Veremos como establecer un tiempo de espera antes de forzar 
 * el cierre de las tareas pendientes.
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class PmhConsola403 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) {
        ExecutorService servicio = Executors.newCachedThreadPool();

        //Establecemos dos tareas de prueba, la primera agotara el tiempo de espera
        //la segunda concluira dentro del periodo de espera.
        Tarea definicionTarea = new Tarea(4, 1000);
        Future<String> resultadoFuturo = servicio.submit(definicionTarea);
        Tarea definicionTarea2 = new Tarea(2, 500);
        Future<String> resultadoFuturo2 = servicio.submit(definicionTarea2);

        try {
            //Iniciamos el apagado del servicio.
            servicio.shutdown();
            //damos un tiempo al servicio para que termine, si las tareas terminan
            //antes no se agota el tiempo de espera. 
            //Importante: USAR tras invocar al método shutdown
            servicio.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Excepcion: error al parar alguna tarea");
        } finally {
            //Si el servicio no ha tenido tiempo de terminar forzamos el cierre
            if (servicio.isTerminated() == false) {
                System.out.println("Mato las tareas que todavía no se han completado");
                servicio.shutdownNow();
            }
        }

        //Tratamos de recuperar el resultado de una tarea registrada en el servicio y que
        //no ha podido ejecutarse
        String resultado = null;
        try {
            resultado = resultadoFuturo.get();
        } catch (ExecutionException ex) {
            System.out.println("Excepcion: la tarea ha sido cancelada antes de terminar, no existen datos en get");
        } catch (InterruptedException ex) {
            System.out.println("Aqui no debería entrar");
        }

        System.out.println("Valor resultadoFuturo: " + resultado);
        
        //Recuperamos el resultado de una tarea registrada en el servicio y que termino
        //su ejecución
        String resultado2 = null;
        try {
            resultado2 = resultadoFuturo2.get();
        } catch (ExecutionException ex) {
            System.out.println("Aqui no debería entrar");
        } catch (InterruptedException ex) {
            System.out.println("Aqui no debería entrar");
        }
        System.out.println("Valor resultadoFuturo2: " + resultado2);
        
        System.out.println("Finaliza el hilo principal");
    }

}
