/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import cadestudio.CADESTUDIO;
import cadestudio.Estudio;
import cadestudio.ExcepcionEstudio;
import cadestudio.Videojuego;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class prueba {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException Excepciones asociadas a la base de datos
     * @throws java.io.IOException excepcion que termina la ejeccución del prograna
     */
    public static void main(String[] args) throws SQLException, IOException {
        int i = 1;
        Integer b =i;
        
        Integer x = 0001;
        System.out.println(b);
        System.out.println(x);
        Scanner teclado= new Scanner(System.in);
        String apoyo = teclado.nextLine();
        System.out.println("" + apoyo + 
                "");
        /*   // TODO code application logic 
        Estudio s = new Estudio();
       // ArrayList<Estudio> er;
       // ArrayList<Videojuego> ev;
       
        s.setNombre_estudio("zzzzz");
        s.setEmail("zzzz@ae");
        
       Videojuego v = new Videojuego();
        v.setEstudio_id(s);
        v.setVideojuego_id(7);
        v.setNombre_videojuego("jojos bizarre");
        v.setVersion_actual("ab4");
        v.setPrecio_salida(20.01);
        v.setPrecio_actual(0.0);
        v.setGenero('a');
        try{
            /*CADESTUDIO cad = new CADESTUDIO();
            cad.leerEstudios();
            
            
        } catch (ExcepcionEstudio e){
            System.out.println(e.toString());
        }
        */
    }
    
}
