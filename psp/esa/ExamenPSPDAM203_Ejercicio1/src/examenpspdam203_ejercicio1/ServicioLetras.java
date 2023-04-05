/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenpspdam203_ejercicio1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM203
 */
//ESTE SERA EL SERVICIO QUE CONTIENE EL COMPORTAMIENTO DEL MISMO Y SU NOMBRE
public class ServicioLetras extends Thread{
    String nombre;
    
    //COSNTRUCTOR DEL SERVIICO CON SU NOMBRE
    public ServicioLetras(String nombre) {
        this.nombre = nombre;
    }
    
    //COMPORTAMIENTO DEL METODO, RECORRE DE LA A A LA Z sumando iteracciones,
    //Por cada iteraccion sacamos una linea por consola diciendo la Letra del abecedario que ha sacado y el nombre del servicio que lo ha hecho.
    //Despues dormirmos el hilo 200milisegundos
     @Override
    public void run() {
        for(char car='A';car<='Z';car++){   
            try {
                System.out.println(nombre + " Saca el caracter " + car);
                Thread.sleep (200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServicioLetras.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
