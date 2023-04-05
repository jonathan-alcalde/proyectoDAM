/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castillo_cantero_ivan_04_hilos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM204
 */
public class Hilo extends Thread {

    private int numero;
    private Monitor m;

    public Hilo() {
    }

    public Hilo(int numero, Monitor m) {
        this.numero = numero;
        this.m = m;
    }

    public void suspender() {
        m.setSuspendido(true);
    }
    
    public void resumir() {
        m.setSuspendido(false);
    }
    
    @Override
    public void run() {
        try {
            while (numero > 0) {
                m.esperarAResumir();
                System.out.println(getName() + ": " + numero);
                numero--;
                Thread.sleep(400);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
