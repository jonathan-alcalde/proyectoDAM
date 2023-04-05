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
public class ProcesoBorrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creación del Runtime con la eliminación de directorio (dentro de la carpeta de proyecto)
        //Especificar reuta en otro caso; RD o RMDIR son aceptados por CMD
        String nombreDirectorio = "DirectorioExamen";
        Runtime runtimeRD = Runtime.getRuntime();
        Process procesoBorrado;
        String comandoRD = "cmd /C RD /S /Q" + nombreDirectorio;
        int flagProceso = -5;
        
        //Gestión de probables excepciones
        try {
            //Feedback a usuario del proceso
            System.out.println("1* Se va a lanzar el proceso");
            System.out.println("Borrando el directorio: " + nombreDirectorio);
            
            //Lanzamimento del proceso
            procesoBorrado = runtimeRD.exec(comandoRD);
            System.out.println("2* Proceso en ejecución... ... ...");
            
            //Recogida del flag
            flagProceso = procesoBorrado.waitFor();
            
            //Gestión de la salida de consola
            //Recogida en stream y almacen en buffer
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            
            //Captura de estado y fin del proceso para su posterior feedback
            if (flagProceso == 0) {
                is = procesoBorrado.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                is = procesoBorrado.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
            
            //Feedback y tokenización de las líneas de recogida
            String salidaConsola = br.readLine();
            
            //Recogida exitosa
            if (salidaConsola == null) {
                //Impresión línea de feedback
                System.out.println("3* Directorio " + nombreDirectorio + "borrado");
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
