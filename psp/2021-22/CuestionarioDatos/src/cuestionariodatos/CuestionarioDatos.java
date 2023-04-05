/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuestionariodatos;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class CuestionarioDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nombre; //contiene letras y espacios en blanco
        String dni; //contiene 8 números y una letra
        String movil; //solo contiene números
        int edad; //solo números
        String genero; //solo letras
        String apoyo;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("----- INICIO de ENTRADA de datos -----");
        
        System.out.println("Introduce tu nombre y apellido: ");
        apoyo = teclado.nextLine();
        while (!contieneSoloLetras(apoyo) || apoyo.length() < 3) {
            System.out.println("Dato erróneo. Introduce de nuevo tu nombre y apellido: ");
            apoyo = teclado.nextLine();
        }
        nombre = apoyo;
        
        System.out.println("Introduce tu DNI: ");
        apoyo = teclado.nextLine();
        while (!contieneLetrasNumeros(apoyo.trim()) || apoyo.length() != 9) {
            System.out.println("Dato erróneo. Introduce de nuevo el DNI: ");
            apoyo = teclado.nextLine();
        }
        dni = apoyo;
        
        System.out.println("Introduce tu número del móvil: ");
        apoyo = teclado.nextLine();
        while(!contieneSoloNumeros(apoyo.trim()) || apoyo.length() != 9) {
            System.out.println("Dato erróneo. Introduce de nuevo el número del móvil: ");
            apoyo = teclado.nextLine();
        }
        movil = apoyo;
        
        System.out.println("Introduce tu edad: ");
        apoyo = teclado.nextLine();
        while(!contieneSoloNumeros(apoyo.trim()) || !(apoyo.length() > 0 && apoyo.length() < 3)) {
            System.out.println("Dato erróneo. Introduce de nuevo tu edad: ");
            apoyo = teclado.nextLine();
        }
        edad = Integer.parseInt(apoyo);
        
        System.out.println("Introduce tu género: ");
        apoyo = teclado.nextLine();
        while(!(contieneSoloLetras(apoyo.trim())) || apoyo.length() < 0) {
            System.out.println("Dato erróneo. Introduce de nuevo tu género: ");
            apoyo = teclado.nextLine();
        }
        genero = apoyo;
        
        System.out.println("----- FIN de ENTRADA de datos -----");
        
        System.out.println("----- INICIO de SALIDA de datos -----");
        
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Móvil: " + movil);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
        
        System.out.println("----- FIN de SALIDA de datos -----");
    }
    
    public static boolean contieneSoloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean contieneLetrasNumeros(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        return true;
    }
    
     public static boolean contieneSoloNumeros(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
    
}
