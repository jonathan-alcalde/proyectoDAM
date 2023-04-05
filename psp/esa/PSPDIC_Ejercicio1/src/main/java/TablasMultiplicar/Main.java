/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TablasMultiplicar;

import java.util.Scanner;

/**
 *
 * @author palom
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Declaración y construcción de variables, objetos y teclado de entrada
        HiloTablaMultiplicar num1 = new HiloTablaMultiplicar();
        HiloTablaMultiplicar num2 = new HiloTablaMultiplicar();
        HiloTablaMultiplicar num3 = new HiloTablaMultiplicar();
        HiloTablaMultiplicar num4 = new HiloTablaMultiplicar();

        int numFinal = -10;
        Scanner teclado = new Scanner(System.in);

        //Recogida del número inicial para la tabla
        System.out.println("Número entre 1 y 9 para la tabla de multiplicar, se mostrarán también los 3 siguientes: ");
        System.out.println("----------------------------------------------------------------------------------------");

        //Gestión iterativa del número de recogida y su validez
        do {
            try {
                //Parseo y validación del número
                numFinal = Integer.parseInt(teclado.nextLine());

                //Feedback a usuario del error
                if (numFinal < 1 || numFinal > 9) {
                    System.err.print("NO VALIDO! Sólo entre 1 y 9 inclusive, por favor introduzca un valor nuevamente: ");
                }
            } catch (NumberFormatException ex) {
                System.err.print("Entrada de tipo erróneo. Probar nuevamente: ");
            }
        } while (numFinal < 1 || numFinal > 9);

        //Declaración y construcción de los números para la tabla de multiplicar
        if (numFinal <= 6) {
            //Modificación y ajuste de atributos de los hilos de los números para las tablas (sin gestión necesaria)
            num1.setNumero(numFinal);
            num2.setNumero(numFinal + 1);
            num3.setNumero(numFinal + 2);
            num4.setNumero(numFinal + 3);

            //Lanzamiento de los hilos
            num1.start();
            num2.start();
            num3.start();
            num4.start();
        } else {
            //Gestión del número para no sobrepasar las tablas
            //Condicional de elección para el 7, 8 y 9
            switch (numFinal) {
                //Caso num 7; reinicio 1
                case 7:
                    //Modificación y ajuste de atributos de los hilos de los números para las tablas (gestión num 7)
                    num1.setNumero(numFinal);
                    num2.setNumero(numFinal + 1);
                    num3.setNumero(numFinal + 2);
                    num4.setNumero(1);
                    
                    //Lanzamiento de los hilos
                    num1.start();
                    num2.start();
                    num3.start();
                    num4.start();
                break;
                
                //Caso num 8; reinicio 1 y 2
                case 8:
                    //Modificación y ajuste de atributos de los hilos de los números para las tablas (gestión num 8)
                    num1.setNumero(numFinal);
                    num2.setNumero(numFinal + 1);
                    num3.setNumero(1);
                    num4.setNumero(2);
                    
                    //Lanzamiento de los hilos
                    num1.start();
                    num2.start();
                    num3.start();
                    num4.start();
                break;    

                //Caso num 9; reinicio 1, 2 y 3
                case 9:
                    //Modificación y ajuste de atributos de los hilos de los números para las tablas (gestión num 9)
                    num1.setNumero(numFinal);
                    num2.setNumero(1);
                    num3.setNumero(2);
                    num4.setNumero(3);
                    
                    //Lanzamiento de los hilos
                    num1.start();
                    num2.start();
                    num3.start();
                    num4.start();                
                break;    
            }
        }
        
        //Cierre del teclado antes del finl del programa
        teclado.close();
    }

}
