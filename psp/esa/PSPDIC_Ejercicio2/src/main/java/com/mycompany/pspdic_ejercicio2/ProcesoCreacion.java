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
public class ProcesoCreacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creación del PB con el mkdir de directorio, creación dentro de carpeta de proyecto
        String nombreDirectorio = "DirectorioExamen";
        ProcessBuilder pbMKDIR = new ProcessBuilder("cmd.exe", "/C", "MKDIR", nombreDirectorio);
        int flagProceso = -5;
        
        //Gestión de probables excepciones
        try {
            //Comienzo de vida del proceso y comunicación al usuario
            System.out.println("1* Se va a lanzar el proceso");
            System.out.println("Creando el directorio: + nombreDirectorio");
            Process procesoCreacion = pbMKDIR.start();
            System.out.println("2* Proceso en ejecución... ... ...");
            
            //Gestión del proceso y flag de ejecución/finalización
            flagProceso = procesoCreacion.waitFor();
            
            //Gestión de la salida de consola
            //Recogida en stream y almacén en buffer
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            
            //Captura de estadp y fin de proceso para su posterior feedback
            if (flagProceso ==0) {
                is = procesoCreacion.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                is = procesoCreacion.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
            
            //Feedback y tokenización de las líneas de la recogida
            String salidaConsola = br.readLine();
            
            //Recogida exitosa
            if (salidaConsola == null) {
                //Impresión línea de feedback
                System.out.println("3* Directorio + nombreDirectorio + creado con éxito!");
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
         
            //Captura de las excepciones
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
