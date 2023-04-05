
package esconsola001;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * En esta clase se muestra:
 *  1. Cómo validar que un dato de entrada es de un determinado tipo
 *  2. Cómo solicitar iterativamente la introducción de dicho dato hasta que sea del tipo correcto
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola001 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        int cantidadHermanos;
        int cantidadCoches;
        double longitud;
        Date fechaExamen = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String apoyo;

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("----- INICIO de ENTRADA de datos !!!");
        
        System.out.print("Introduce cuántos hermanos tienes: ");
        apoyo = teclado.nextLine();
        while (!apoyo.matches("-?\\d+")) {
            System.out.print("Dato erróneo. Introduce de nuevo cuántos hermanos tienes: ");
            apoyo = teclado.nextLine();
        }
        cantidadHermanos = Integer.parseInt(apoyo);
        
        System.out.print("Introduce cuántos coches tienes: ");
        apoyo = teclado.nextLine();
        while (!esEntero(apoyo)) {
            System.out.print("Dato erróneo. Introduce de nuevo cuántos coches tienes: ");
            apoyo = teclado.nextLine();
        }
        cantidadCoches = Integer.parseInt(apoyo);
        
        System.out.print("Introduce la distancia entre el punto X y el punto Y: ");
        apoyo = teclado.nextLine();
        while (!esDoble(apoyo)) {
            System.out.print("Dato erróneo. Introduce de nuevo la distancia entre el punto X y el punto Y: ");
            apoyo = teclado.nextLine();
        }
        longitud = Double.parseDouble(apoyo);
        
        System.out.print("Introduce la fecha del examen: ");
        apoyo = teclado.nextLine();
        while (!esFecha(apoyo)) {
            System.out.print("Dato erróneo. Introduce de nuevo la fecha del examen: ");
            apoyo = teclado.nextLine();
        }
        try {
            fechaExamen = sdf.parse(apoyo);
        } catch (ParseException e) {
        }
        
        System.out.println("----- FIN de ENTRADA de datos !!!");
            
        System.out.println("----- INICIO de SALIDA de datos !!!");
        
        System.out.println("Cantidad de hermanos: " + cantidadHermanos);
        System.out.println("Cantidad de coches: " + cantidadCoches);
        System.out.println("Longitud: " + longitud);
        System.out.println("Fecha de examen: " + fechaExamen);
        
        System.out.println("----- FIN de SALIDA de datos !!!");
    }
    
    /**
     * Método que valida si un string contiene un dato de tipo int válido
     * @param s String a validar si contiene un dato de tipo int válido
     * @return true si el string contiene un dato de tipo int válido o false en caso contrario
    */
    public static boolean esEntero(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    /**
     * Método que valida si un string contiene un dato de tipo double válido
     * @param s String a validar si contiene un dato de tipo double válido
     * @return true si el string contiene un dato de tipo double válido o false en caso contrario
    */
    public static boolean esDoble(String s) {
        try { 
            Double.parseDouble(s);
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    /**
     * Método que valida si un string contiene un dato de clase SimpleDateFormat válido
     * @param s String a validar si contiene un dato de clase SimpleDateFormat válido
     * @return true si el string contiene un dato de clase SimpleDateFormat válido o false en caso contrario
    */
    public static boolean esFecha(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try { 
            sdf.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    
}
