/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablasMultiplicar;

/**
 *
 * @author palom
 */
public class HiloTablaMultiplicar  extends Thread{
    
    // ATRIBUTOS
    
    public int numero;
    
    // GETTERS Y SETTERS
    
    public void setNumero(int numero) {
      this.numero = numero;
    }

    public HiloTablaMultiplicar() {
    }

    public HiloTablaMultiplicar(int numero) {
        this.numero = numero;
    }
        
    //Método sobreescrito para la ejecución del hilo
    
    public void run(){
        //Variable del cálculo de cada iteración de la tabla de multiplicar
        int calculoIteracion = 0;
        
        //Bucle para el cálculo de la tabla de multiplicar
        for (int iteracion = 1; iteracion <= 10; iteracion++) {
            //Cálculo de la operación y muestreo
            calculoIteracion = numero + iteracion;
            System.out.println("Tabla del: " + numero + "por " + iteracion + " = " + calculoIteracion);
            
            //Gestión de la paulsa en milisegundos y la excepcion de interrupción
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
