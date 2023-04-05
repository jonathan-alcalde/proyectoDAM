/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspdic_ejercicio3;

/**
 *
 * @author palom
 */
public class Atleta extends Thread{
    
    private String nombre;
    private double tiempoIntervalo1;
    private double tiempoIntervalo2;
    private double tiempoIntervalo3;
    private double tiempoIntervalo4;
    private Atleta atletaPrevio;

    public Atleta(String nombre, double tiempoIntervalo1, double tiempoIntervalo2, double tiempoIntervalo3, double tiempoIntervalo4) {
        this.nombre = nombre;
        this.tiempoIntervalo1 = tiempoIntervalo1;
        this.tiempoIntervalo2 = tiempoIntervalo2;
        this.tiempoIntervalo3 = tiempoIntervalo3;
        this.tiempoIntervalo4 = tiempoIntervalo4;
        this.atletaPrevio = null;
    }

    public Atleta(String nombre, double tiempoIntervalo1, double tiempoIntervalo2, double tiempoIntervalo3, double tiempoIntervalo4, Atleta atletaPrevio) {
        this.nombre = nombre;
        this.tiempoIntervalo1 = tiempoIntervalo1;
        this.tiempoIntervalo2 = tiempoIntervalo2;
        this.tiempoIntervalo3 = tiempoIntervalo3;
        this.tiempoIntervalo4 = tiempoIntervalo4;
        this.atletaPrevio = atletaPrevio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTiempoIntervalo1() {
        return tiempoIntervalo1;
    }

    public void setTiempoIntervalo1(double tiempoIntervalo1) {
        this.tiempoIntervalo1 = tiempoIntervalo1;
    }

    public double getTiempoIntervalo2() {
        return tiempoIntervalo2;
    }

    public void setTiempoIntervalo2(double tiempoIntervalo2) {
        this.tiempoIntervalo2 = tiempoIntervalo2;
    }

    public double getTiempoIntervalo3() {
        return tiempoIntervalo3;
    }

    public void setTiempoIntervalo3(double tiempoIntervalo3) {
        this.tiempoIntervalo3 = tiempoIntervalo3;
    }

    public double getTiempoIntervalo4() {
        return tiempoIntervalo4;
    }

    public void setTiempoIntervalo4(double tiempoIntervalo4) {
        this.tiempoIntervalo4 = tiempoIntervalo4;
    }

    public Atleta getAtletaPrevio() {
        return atletaPrevio;
    }

    public void setAtletaPrevio(Atleta atletaPrevio) {
        this.atletaPrevio = atletaPrevio;
    }
    
    
    //Método RUN sobreescrito
    public void run() {
        //Si hay atleta previo, secuencio con el mismo
        //Parametrizado desde la construcción del objeto
        if (atletaPrevio != null) {
            try {
                atletaPrevio.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        
        try {
            //Saltos de valla para el atleta
            //Muestreo de feedback a usuario del atleta previa gestión de su carrera
            System.out.println("[Soy el atleta: " + nombre + "con intervalo 1 de " + Math.round(tiempoIntervalo1 * 100) / 100.0 +
                                                           ", con intervalo 2 de " + Math.round(tiempoIntervalo2 * 100) / 100.0 +
                                                           ", con intervalo 3 de " + Math.round(tiempoIntervalo3 * 100) / 100.0 +
                                                           ", con intervalo 4 de " + Math.round(tiempoIntervalo4 * 100 / 100.0) + " ]");
            
            //Gestión de los intervalos y los saltos de valla
            Thread.sleep((long) (tiempoIntervalo1 * 1000)); //sleep espera el tiempo en milisegs
            System.out.println("____" + getNombre() + " salta la PRIMERA valla");
            Thread.sleep((long) (tiempoIntervalo1 * 1000)); //sleep espera el tiempo en milisegs
            System.out.println("________" + getNombre() + " salta la SEGUNDA valla");
            Thread.sleep((long) (tiempoIntervalo1 * 1000)); //sleep espera el tiempo en milisegs
            System.out.println("____________" + getNombre() + " salta la TERCERA valla");
            Thread.sleep((long) (tiempoIntervalo1 * 1000)); //sleep espera el tiempo en milisegs
            System.out.println("******************* " + getNombre() + " ha terminado ****************************");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
