package esconsola000;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * En esta clase se muestra:
 *  1. Cómo introducir datos de diferentes tipos por teclado
 *  2. Cómo mostrar datos de diferentes tipos por consola
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola000 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        String nombre;
        String contrasena;
        int tallaZapato;
        double sueldo;
        long altura;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String textoFecha;
        Date fechaHoraNacimiento;

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("----- INICIO de ENTRADA de datos !!!");
        try {
            System.out.print("Introduce tu nombre: ");
            nombre = teclado.nextLine();
            System.out.print("Introduce tu fecha y hora de nacimiento (yyyy-MM-dd hh:mm:ss): ");
            textoFecha = teclado.nextLine();
            fechaHoraNacimiento = sdf.parse(textoFecha);
            System.out.print("Introduce tu contraseña: ");
            contrasena = teclado.next();
            System.out.print("Introduce tu talla de zapato: ");
            tallaZapato = teclado.nextInt();
            System.out.print("Introduce tu sueldo: ");
            sueldo = teclado.nextDouble();
            System.out.print("Introduce tu altura: ");
            altura = teclado.nextLong();
        }
        catch (InputMismatchException e) {
            System.out.println("ERROR de tipo de datos: " + e.getMessage());
            return;
        } 
        catch (ParseException e) {
            System.out.println("ERROR en la conversión de fecha: " + e.getMessage());
            return;
        }
        finally {
            System.out.println("----- FIN de ENTRADA de datos !!!");
        }
        
        System.out.println("----- INICIO de SALIDA de datos !!!");
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha y hora de Nacimiento: " + fechaHoraNacimiento);
        System.out.println("Contraseña: " + contrasena);
        System.out.println("Talla de Zapato: " + tallaZapato);
        System.out.println("Suelto: " + sueldo);
        System.out.println("Altura: " + altura);
        System.out.println("----- FIN de SALIDA de datos !!!");

        }
    
}
