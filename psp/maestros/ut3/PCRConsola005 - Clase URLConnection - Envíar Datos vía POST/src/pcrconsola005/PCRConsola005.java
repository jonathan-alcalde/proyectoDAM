/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pcrconsola005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * En esta clase se muestra cómo enviar valores vía POST a una URL y a recibir su respuesta
 * Requisitos previos: es necesario instalar en un servidor web que permita php los ficheros
 * pregunta.php y respuesta.php que se encuentran en la carpeta maniobra del proyecto
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PCRConsola005 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        System.out.println("Obteniendo la respuesta de una Conexión URL:");
        try {
//            URL url = new URL("http://192.168.1.174/respuesta.php");
            URL url = new URL("http://127.0.0.1/respuesta.php");
            URLConnection conexionURL = url.openConnection();
            conexionURL.setDoOutput(true);

            String query = "nombre=Ignacio&apellidos=FH";
            OutputStream os = conexionURL.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write(query);
            pw.close();
            
            InputStream is = conexionURL.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
