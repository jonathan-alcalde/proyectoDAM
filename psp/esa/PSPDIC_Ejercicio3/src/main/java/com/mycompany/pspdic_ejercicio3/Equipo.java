/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspdic_ejercicio3;

/**
 *
 * @author palom
 */
class Equipo extends Thread{
    
    protected String nombre;
    protected Atleta atleta1;
    protected Atleta atleta2;
    protected Atleta atleta3;

    public Equipo(String nombre) {
        //Construcción definida; nombre y tiempos de intervalo aleatorios para hipotéticos atletas
        this.nombre = nombre;
        double tIntervalo1, tIntervalo2, tIntervalo3, tIntervalo4;
    
    
    /** Generación atleta 1*/
    //Aleatoriedad ee los tiempos de intervalo de vallas
    tIntervalo1 = Math.random();
    tIntervalo2 = Math.random();
    tIntervalo3 = Math.random();
    tIntervalo4 = Math.random();
    
    //Normalizacion de tiempos en picos mínimos
    if (tIntervalo1 < 0.3) 
        tIntervalo1 = tIntervalo1 + 0.3;
    if (tIntervalo2 < 0.3) 
        tIntervalo2 = tIntervalo2 + 0.3;    
    if (tIntervalo3 < 0.3) 
        tIntervalo3 = tIntervalo3 + 0.3;    
    if (tIntervalo4 < 0.3) 
        tIntervalo4 = tIntervalo4 + 0.3;
    
    //Construcción
    this.atleta1 = new Atleta(nombre + " 1", tIntervalo1, tIntervalo2, tIntervalo3, tIntervalo4);
    
    /** Generación atleta 2*/
    //Aleatoriedad ee los tiempos de intervalo de vallas
    tIntervalo1 = Math.random();
    tIntervalo2 = Math.random();
    tIntervalo3 = Math.random();
    tIntervalo4 = Math.random();
    
    //Normalizacion de tiempos en picos mínimos
    if (tIntervalo1 < 0.3) 
        tIntervalo1 = tIntervalo1 + 0.3;
    if (tIntervalo2 < 0.3) 
        tIntervalo2 = tIntervalo2 + 0.3;    
    if (tIntervalo3 < 0.3) 
        tIntervalo3 = tIntervalo3 + 0.3;    
    if (tIntervalo4 < 0.3) 
        tIntervalo4 = tIntervalo4 + 0.3;
    
    //Construcción
    this.atleta2 = new Atleta(nombre + " 2", tIntervalo1, tIntervalo2, tIntervalo3, tIntervalo4);
    
    /** Generación atleta 3*/
    //Aleatoriedad ee los tiempos de intervalo de vallas
    tIntervalo1 = Math.random();
    tIntervalo2 = Math.random();
    tIntervalo3 = Math.random();
    tIntervalo4 = Math.random();
    
    //Normalizacion de tiempos en picos mínimos
    if (tIntervalo1 < 0.3) 
        tIntervalo1 = tIntervalo1 + 0.3;
    if (tIntervalo2 < 0.3) 
        tIntervalo2 = tIntervalo2 + 0.3;    
    if (tIntervalo3 < 0.3) 
        tIntervalo3 = tIntervalo3 + 0.3;    
    if (tIntervalo4 < 0.3) 
        tIntervalo4 = tIntervalo4 + 0.3;
    
    //Construcción
    this.atleta3 = new Atleta(nombre + " 3", tIntervalo1, tIntervalo2, tIntervalo3, tIntervalo4);
    }
    
    //Método sobreescrito de Thread
    //Lanzamiento de los atletas (hilos)
    public void run() {
        this.atleta1.start();
        this.atleta2.start();
        this.atleta3.start();
    }
    
}
