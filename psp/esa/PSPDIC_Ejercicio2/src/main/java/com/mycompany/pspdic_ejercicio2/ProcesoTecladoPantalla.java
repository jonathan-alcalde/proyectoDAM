/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pspdic_ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author palom
 */
public class ProcesoTecladoPantalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Proceso de lanzamiento de teclado en pantalla
        //PB para el OSK.exe
        ProcessBuilder PBOSK = new ProcessBuilder ("cmd.exe", "C/", "OSK.exe");
        int flagProceso = -5;
        
        //Gestión de probables excepciones
        try {
            //Feedback al usuario del proceso
            System.out.println("1* Se va a lanzar el proceso");
            System.out.println("Creando el teclado en pantalla");
            
            //Lanzamiento del proceso
            Process procesoTecladoPantalla = PBOSK.start();
            System.out.println("2* Proceso en ejecución... ... ...");
            
            //Recogida del flag
            flagProceso = procesoTecladoPantalla.waitFor();
            
            //Gestión de la salida de consola
            //Recogida en stream y almacen en buffer
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            
            //Captura de estado y fin del proceso para su posterior feedback
            if (flagProceso == 0) {
                is = procesoTecladoPantalla.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                is = procesoTecladoPantalla.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
            
            //Feedback y tokenización de las líneas de la recogida
            String salidaConsola = br.readLine();
            
            //Recogida exitosa
            
            if (salidaConsola == null) {
                //Impresión llínea de feedback
                System.out.println("3* Teclado en pantalla ejecutado y finalizado con éxito");
            }
            
            //Gestión y recogida de mensaje
            while (salidaConsola != null) {
                System.out.println(salidaConsola);
                salidaConsola = br.readLine();
            }
            
            //Cierre de todos los buffers y stream
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
