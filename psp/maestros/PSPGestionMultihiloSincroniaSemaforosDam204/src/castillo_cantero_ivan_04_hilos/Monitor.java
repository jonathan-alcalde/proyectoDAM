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
public class Monitor {
    
    private boolean suspendido;
    
    public Monitor() {
        Hilo h1 = new Hilo(10, this);
        h1.setName("Hilo 1");
        
        h1.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        h1.suspender();
        System.out.println("Hilo suspendido por 2 segundos");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        h1.resumir();
    }

    public boolean isSuspendido() {
        return suspendido;
    }

    synchronized public void setSuspendido(boolean suspendido) {
        this.suspendido = suspendido;
        notify();
    }
    
    synchronized public void esperarAResumir () throws InterruptedException {
        while (suspendido) {
            wait();
        }
    }
}
