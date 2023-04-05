package pmhconsola401;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * En esta clase se muestra cómo crear tareas asincronas que pueden devolver resultados. 
 * @author Alejandro López Camus
 * @version 1.0
 * @since PSP 1.0
 */
public class PmhConsola401 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {    
        //Instanciamos el servicio encargado de procesar las tareas
        ExecutorService servicio = Executors.newCachedThreadPool();
        
        //Instanciamos 4 tareas que implementan la interfaz Callable. la interfaz callable es 
        //equivalente a la interfaz Runnable con la diferencia de poder devolver un valor
        Tarea t1 = new Tarea(4);
        Tarea t2 = new Tarea(6);
        Tarea t3 = new Tarea(8);
        Tarea t4 = new Tarea(10);               
             
        //Asignamos las tareas al servicio, al ser de tipo Callable la asignación nos devuelve
        //como resultado un objeto de tipo Future. El tipo future representa un resultado asincrono
        Future<Integer> f1 = servicio.submit(t1);
        Future<Integer> f2 = servicio.submit(t2);
        Future<Integer> f3 = servicio.submit(t3);
        Future<Integer> f4 = servicio.submit(t4);
        
        //Mostramos el resultado de las tareas. El método get() es sincrono por lo su llamada
        //bloqueara la ejecución hasta que se origine el resultado.
        System.out.println("Resultado de f1[" + t1.numero + "]: " + f1.get());
        System.out.println("Resultado de f2[" + t2.numero + "]: " + f2.get());
        System.out.println("Resultado de f3[" + t3.numero + "]: " + f3.get());
        System.out.println("Resultado de f4[" + t4.numero + "]: " + f4.get());

        //Apagamos el servicio
        servicio.shutdown();
        System.out.println("Termina el hilo principal");    
    }
    
}
