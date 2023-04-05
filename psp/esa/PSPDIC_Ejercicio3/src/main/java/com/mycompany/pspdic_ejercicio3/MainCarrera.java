/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pspdic_ejercicio3;

/**
 *
 * @author palom
 */
public class MainCarrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // INICIO____________VALLA1____________VALLA2____________VALLA3__________FIN
        //       intervalo1        intervalo2        intervalo3        intervalo4
        
        //Declaración y construcción de equipos
        Equipo eqRojo = new Equipo("Rojo");
        Equipo eqBlanco = new Equipo("Blanco");
        
        //Comienzo de carrera
        System.out.println("Comienza la carrera \n");
        eqRojo.start();
        eqBlanco.start();
    }
    
}
