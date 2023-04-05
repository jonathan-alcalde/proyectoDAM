package esconsola020;

import java.util.Scanner;

/**
 * En esta clase se muestra:
 *  1. Cómo crear y manejar excepciones verificadas
 *  2. Cómo crear y manejar excepciones no verificadas
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola020 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
     * @throws ExcepcionNoVerificada en el caso de que se introduzca el número 13
    */
    public static void main(String[] args) {
        int a;
        int b;
        int res;
        
        Scanner teclado = new Scanner (System.in);
        
        System.out.print("Valor de a: ");
        a = teclado.nextInt();
        if (a == 13) try {
            throw new ExcepcionVerificada("13 está prohibido !!!");
        } catch (ExcepcionVerificada ex) {
            System.out.println("Error: " + ex.getMessage());
            return;
        }
        
        System.out.print("Valor de b: ");
        b = teclado.nextInt();
        if (b == 13) throw new ExcepcionNoVerificada("13 está prohibido !!!"); 
        
        res = a * b;
        
        System.out.println("Resultado: " + res);

    }
    
}
