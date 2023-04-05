/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1letrasexamenivancastillo;

/**
 *
 * @author DAM204
 */
public class Letra extends Thread {
    private String nombre;

    public Letra(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.println(nombre + ": " + i);
        }
    }
    
}
