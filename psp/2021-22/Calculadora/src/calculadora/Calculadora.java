/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author USUARIO
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PropertyConfigurator.configure("maniobra\\log4j.properties");
        Logger logger = LogManager.getLogger("NAVEGACION");
        int x;
        int y;
        int operacion;
        String apoyo;

        Scanner teclado = new Scanner(System.in);

        System.out.println("----- INICIO de ENTRADA de datos");

        System.out.println("Introduce el primer número entero.");
        apoyo = teclado.nextLine();
        try {
            Integer.parseInt(apoyo);
        } catch (NumberFormatException ex) {
            System.out.println("Error al introducir número: " + ex.getMessage());
            logger.error("Error al introducir número");
            return;
        }
        x = Integer.parseInt(apoyo);

        System.out.println("Introduce el segundo número entero.");
        apoyo = teclado.nextLine();
        try {
            Integer.parseInt(apoyo);
        } catch (NumberFormatException ex) {
            System.out.println("Error al introducir número: " + ex.getMessage());
            logger.error("Error al introducir número");
            return;
        }
        y = Integer.parseInt(apoyo);

        System.out.println("Escribe 1 si quieres hacer una suma.");
        System.out.println("Escribe 2 si quieres hacer una resta.");
        System.out.println("Escribe 3 si quieres hacer una multiplicación");
        System.out.println("Escribe 4 si quieres hacer una división.");

        apoyo = teclado.nextLine();

        if ("1".equals(apoyo)) {
            System.out.println(x + " + " + y + " = " + (x + y));
            logger.info("Suma");
        }
        else if ("2".equals(apoyo)) {
            System.out.println(x + " - " + y + " = " + (x - y));
            logger.info("Resta");
        }
        else if ("3".equals(apoyo)) {
            System.out.println(x + " * " + y + " = " + (x * y));
            logger.info("División");
        }
        else if ("4".equals(apoyo)) {
            try {
                System.out.println(x + " / " + y + " = " + (x / y));
                System.out.println("De resto tiene " + (x % y));
            } catch (ArithmeticException ex) {
                System.out.println("No se puede dividir entre 0.");
                logger.error("Error al dividir entre 0");
            }
        } else {
            System.out.println("No ha introducido una opción adecuada.");
            logger.error("Error al introducir opción");
        }

    }
}
