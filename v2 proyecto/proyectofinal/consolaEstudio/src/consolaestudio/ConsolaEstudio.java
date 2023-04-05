/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consolaestudio;

import cadestudio.CADESTUDIO;
import cadestudio.Estudio;
import cadestudio.ExcepcionEstudio;
import cadestudio.Videojuego;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import oracle.net.aso.i;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author usuario
 */
public class ConsolaEstudio {
    /**
     * @param args the command line arguments
     */

        
    public static void main(String[] args) throws SQLException, ExcepcionEstudio, IOException {
        // TODO code application logic here
        /*Scanner teclado = new Scanner(System.in);
        int opcion = 0;
            ConsolaEstudio.menu();
            opcion = teclado.nextInt();
           switch (opcion){
            case 1:
                ConsolaEstudio.menuEstudio();
                break;
            case 2:
                ConsolaEstudio.menuVideojuego();
                break;
            case 9:
                System.out.println("Se termina el programa");
                teclado.close();
                System.exit(0);
                break;
            default:
                System.out.println("Error: el dato no coindice con ninguna de las opciones");
            }*/
            ConsolaEstudio.menu();
        
            
    }
    public static void menu() throws SQLException, ExcepcionEstudio, IOException   { 
            PropertyConfigurator.configure("maniobra\\log4j.properties");
            Logger logger = LogManager.getLogger("NAVEGACION");
            logger.trace("Ha iniciado el programa");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Menú Principal");
            System.out.println("---------------------");
            System.out.println("1-Gestión de Estudios");
            System.out.println("2-Gestión de Videojuegos");
            System.out.println("9-Salir");
            String apoyo = teclado.nextLine();
            while (!apoyo.matches("-?\\d+")) {
            System.out.print("Dato erróneo. Introduce de nuevo una opción: ");
            apoyo = teclado.nextLine();
                        };
        int opcion = Integer.parseInt(apoyo);
        switch (opcion){
            case 1:
                logger = LogManager.getLogger("NAVEGACION");
                logger.trace("Ha entrado en la Gestión de Estudios");
                ConsolaEstudio.menuEstudio();
                break;
            case 2:
                logger = LogManager.getLogger("NAVEGACION");
                logger.trace("Ha entrado en la Gestión de Videojuegos");
                ConsolaEstudio.menuVideojuego();
                break;
            case 9:
                logger = LogManager.getLogger("NAVEGACION");
                logger.trace("Ha salido del programa");
                System.out.println("El programa se termina");
                teclado.close();
                System.exit(0);
                break;
            default:
                logger = LogManager.getLogger("NAVEGACION");
                logger.trace("Ha introducido una opción incorrecta en el menu principal" + opcion);
                System.out.println("Error: el dato no coindice con ninguna de las opciones");
                ConsolaEstudio.menu();
            } 
           }
       
    
    public static void menuEstudio() throws SQLException, ExcepcionEstudio, IOException{
        PropertyConfigurator.configure("maniobra\\log4j.properties");
        Logger logger = LogManager.getLogger("NAVEGACION");
        Scanner teclado = new Scanner(System.in);
        Estudio s = new Estudio();
        CADESTUDIO cad = new CADESTUDIO();
       // Estudio s = new Estudio();
        System.out.println("Gestión de Estudios");
        System.out.println("-------------------");
        System.out.println("1-Nuevo Estudio");
        System.out.println("2-Eliminar Estudio");
        System.out.println("3-Actualizar Estudio");
        System.out.println("4-Ver 1 Estudio");
        System.out.println("5-Ver todos los estudios");
        System.out.println("9-Salir");
        String apoyo = teclado.nextLine();
        while (!apoyo.matches("-?\\d+")) {
            System.out.print("Dato erróneo. Introduce de nuevo una opción: ");
            apoyo = teclado.nextLine();
                        };
        int opcion = Integer.parseInt(apoyo);
        
        switch (opcion){
            case 1:
                logger.trace("Ha entrado en la opción de crear Estudio");
                
                System.out.println("Escribe el nombre del nuevo Estudio");
                String nombre_nuevo_estudio = teclado.nextLine();
                s.setNombre_estudio(nombre_nuevo_estudio);
                
                System.out.println("Escribe el email del estudio ");
                String email_nuevo_estudio = teclado.next(); 
                s.setEmail(email_nuevo_estudio);
                
                try{
                    cad.insertarEstudio(s);
                    System.out.println("Inserción realizada correctamente");
                }
                catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());
                   }
                ConsolaEstudio.menuEstudio();
                break;
            case 2:
                logger.trace("Ha entrado en la opción de eliminar Estudio");
                
                
                System.out.println("Escribe el id del estudio que quieras eliminar");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del estudio: ");
                    apoyo = teclado.nextLine();
                };
                int eliminar_id= Integer.parseInt(apoyo);
                
                try{
                    cad.eliminarEstudio(eliminar_id);
                    logger.trace("Se ha eliminado un estudio con éxito");
                    System.out.println("Eliminación realizada correctamente");
                }catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());

                 }
                ConsolaEstudio.menuEstudio();
                break;
            case 3:
                logger.trace("Ha entrado en la opción de modificar Estudio");
                
                System.out.println("Escribe el id del estudio que quieras actualizar");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del estudio: ");
                    apoyo = teclado.nextLine();
                };
                int id_estudio = Integer.parseInt(apoyo);
                s.setEstudio_id(id_estudio);
                
                System.out.println("Escribe el nuevo nombre del estudio");
                String nombre_estudio = teclado.nextLine();
                s.setNombre_estudio(nombre_estudio);
                
                System.out.println("Escribe el nuevo email del estudio");
                String email_estudio = teclado.nextLine();
                s.setEmail(email_estudio);
                
                try{
                    cad.actualizarEstudio(s);
                    logger.trace("Actualización del estudio");
                    System.out.println("Actualización exitosa");
                }
                catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());

                }
                ConsolaEstudio.menuEstudio();
                break;
            case 4:
                logger.trace("Ha entrado en la opción de leer 1 estudio");   
                
                System.out.println("Escribe el id del estudio");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del estudio: ");
                    apoyo = teclado.nextLine();
                };
                int id = Integer.parseInt(apoyo);
                cad.leer1estudio(id);
                s = cad.leer1estudio(id);
                System.out.println(s.getEstudio_id() + " " + s.getNombre_estudio() + " " + s.getEmail());
                System.out.println("Pulsa enter para continuar");
                teclado.nextLine();
                ConsolaEstudio.menuEstudio();
                break;
               case 5:
                logger.trace("Ha entrado en la opción de leer todos los estudios");
                cad.leerEstudios();
                System.out.println("Pulsa enter para continuar");
                teclado.nextLine();
                ConsolaEstudio.menuEstudio();
                break;
            case 9:
                logger.trace("Ha entrado vuelto al menu principal");
                 ConsolaEstudio.menu();
                break;
            default:
                logger.trace("Ha introducido una opción errónea en Estudio" + opcion);
                System.out.println("Error: el dato no coindice con ninguna de las opciones");
                ConsolaEstudio.menuEstudio();
            }  
}
        
        
    
    
    public static void menuVideojuego() throws SQLException, ExcepcionEstudio, IOException{
        PropertyConfigurator.configure("maniobra\\log4j.properties");
        Logger logger = LogManager.getLogger("NAVEGACION");
        Scanner teclado = new Scanner(System.in);
        CADESTUDIO cad = new CADESTUDIO();
        Videojuego v = new Videojuego();
        Estudio s = new Estudio();
        System.out.println("Gestión de Videojuegos");
        System.out.println("-------------------");
        System.out.println("1-Nuevo Videojuego");
        System.out.println("2-Eliminar Videojuego");
        System.out.println("3-Actualizar Videojuego");
        System.out.println("4-Ver 1 Videojuego");
        System.out.println("5-Ver todos los videojuegos");
        System.out.println("9-Salir");
        
        String apoyo = teclado.nextLine(); 
        while (!apoyo.matches("-?\\d+")) {
            System.out.print("Dato erróneo. Introduce de nuevo una opción: ");
            apoyo = teclado.nextLine();
        };
        int opcion = Integer.parseInt(apoyo);
        switch (opcion){
            case 1:
                logger.trace("Ha entrado en la opción de insertar un nuevo Videojuego");
                
                System.out.println("Escribe el nombre del videojuego");
                apoyo = teclado.nextLine();
                v.setNombre_videojuego(apoyo);
                
                System.out.println("Escribe el id del estudio");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo una opción: ");
                    apoyo = teclado.nextLine();
                };
                int id_estudio = Integer.parseInt(apoyo);
                s = cad.leer1estudio(id_estudio);
                v.setEstudio_id(s);
                
                System.out.println("Escribe el género del videojuego");
                apoyo = teclado.nextLine();
                while(apoyo.length() > 1){
                    System.out.println("Dato erróneo. Introduce de nuevo el genero");
                    apoyo = teclado.nextLine();
                }
                v.setGenero(apoyo.charAt(0));
                
                System.out.println("Escribe el precio de salida del videojuego");
                apoyo = teclado.nextLine();
                while(!esDoble(apoyo)){
                    System.out.println("Dato erróneo. Introduce de nuevo el precio de salida");
                    apoyo = teclado.nextLine();
                }
                Double precio_salida = Double.parseDouble(apoyo);
                v.setPrecio_salida(precio_salida);
                
                System.out.println("Escribe el precio actual del videojuego");
                apoyo = teclado.nextLine();
                while( !esDoble(apoyo)){
                    System.out.println("Dato erróneo. Introduce de nuevo el precio actual");
                    apoyo = teclado.nextLine();
                }
                Double precio_actual = Double.parseDouble(apoyo);
                v.setPrecio_actual(precio_actual);
                
                System.out.println("Escribe la version actual");
                 apoyo = teclado.nextLine();
                while(apoyo.isEmpty()){
                    System.out.println("Dato erróneo. Introduce de nuevo la versión");
                    apoyo = teclado.nextLine();
                }
               
               
                v.setVersion_actual(apoyo);
                try{
                    cad.insertarVideojuego(v);
                    logger.trace("Insercion de videojuego");
                    System.out.println("Insercion de videojuego");
                }
                catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());

                }
                ConsolaEstudio.menuVideojuego();
                break;
            case 2:
                logger.trace("Ha entrado en la opción de eliminar un Videojuego");
                 System.out.println("Escribe el id del videojuego que quieras eliminar");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del videojuego: ");
                    apoyo = teclado.nextLine();
                };
                int eliminar_id= Integer.parseInt(apoyo);
                
                try{
                    cad.eliminarVideojuego(eliminar_id);
                    logger.trace("Se ha eliminado un videojuego con éxito");
                    System.out.println("Eliminación realizada correctamente");
                }catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());

                 }
                ConsolaEstudio.menuVideojuego();
                break;
            case 3:
                logger.trace("Ha entrado en la opción de actualizar un Videojuego");
                System.out.println("Escribe el id del videojuego que quieras actualizar");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del videojuego: ");
                    apoyo = teclado.nextLine();
                };
                int id_videojuego = Integer.parseInt(apoyo);
                v.setVideojuego_id(id_videojuego);
                System.out.println("Escribe el nombre del videojuego");
                apoyo = teclado.nextLine();
                v.setNombre_videojuego(apoyo);
                
                System.out.println("Escribe el id del estudio");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo una opción: ");
                    apoyo = teclado.nextLine();
                };
                int id_estudio2 = Integer.parseInt(apoyo);
                
                s = cad.leer1estudio(id_estudio2);
                v.setEstudio_id(s);
                
                System.out.println("Escribe el género del videojuego");
                apoyo = teclado.nextLine();
                while(apoyo.length() > 1){
                    System.out.println("Dato erróneo. Introduce de nuevo el genero");
                    apoyo = teclado.nextLine();
                }
                v.setGenero(apoyo.charAt(0));
                
                System.out.println("Escribe el precio de salida del videojuego");
                apoyo = teclado.nextLine();
                while(!esDoble(apoyo)){
                    System.out.println("Dato erróneo. Introduce de nuevo el precio de salida");
                    apoyo = teclado.nextLine();
                }
                Double precio_salida_act = Double.parseDouble(apoyo);
                v.setPrecio_salida(precio_salida_act);
                
                System.out.println("Escribe el precio actual del videojuego");
                apoyo = teclado.nextLine();
                while(!esDoble(apoyo)){
                    System.out.println("Dato erróneo. Introduce de nuevo el precio actual");
                    apoyo = teclado.nextLine();
                }
                Double precio_actual_act = Double.parseDouble(apoyo);
                v.setPrecio_actual(precio_actual_act);
                
                System.out.println("Escribe la version actual");
                apoyo = teclado.nextLine();
                while(apoyo.isEmpty()){
                    System.out.println("Dato erróneo. Introduce de nuevo la versión");
                    apoyo = teclado.nextLine();
                }
                v.setVersion_actual(apoyo);
                try{
                    cad.actualizarVideojuego(v);
                    logger.trace("Actualización de videojuego");
                    System.out.println("Se ha actualizado un videojuego");
                }
                catch(ExcepcionEstudio ex){
                    System.out.println(ex.getMensajeErrorUsuario());
                    logger = LogManager.getLogger("ERROR");
                    logger.error("ExcepcionEstudio: " + "codigoError=" + ex.getCodigoError() + ", mensajeErrorBD=" + ex.getMensajeErrorBD() + ", mensajeErrorUsuario=" + ex.getMensajeErrorUsuario() + ", sentenciaSQL=" + ex.getSentenciaSQL());

                }
                ConsolaEstudio.menuVideojuego();
                break;
            case 4:
                logger.trace("Ha entrado en la opción de mostrar un Videojuego");
                System.out.println("Escribe el id del videojuego");
                apoyo = teclado.nextLine();
                while (!apoyo.matches("-?\\d+")) {
                    System.out.print("Dato erróneo. Introduce de nuevo el identificador del videojuego: ");
                    apoyo = teclado.nextLine();
                };
                int id = Integer.parseInt(apoyo);
                 v = cad.leer1Videojuego(id);
                 System.out.println(
                        v.getVideojuego_id() + " " 
                        + v.getNombre_videojuego() + " "
                        + v.getGenero() + " "
                        + v.getPrecio_actual() + " "
                        + v.getPrecio_salida() + " "
                        + v.getFecha_ultima_actualizacion() + " "
                        + v.getEstudio_id().getEstudio_id() + " " 
                        + v.getEstudio_id().getNombre_estudio() + " " 
                        + v.getEstudio_id().getEmail());
                         
                System.out.println("Pulsa enter para continuar");
                teclado.nextLine();
                ConsolaEstudio.menuVideojuego();
                break;
            case 5:
                logger.trace("Ha entrado en la opción de ver todos los Videojuegos");
                ArrayList<Videojuego> d = new ArrayList();
                d.containsAll(cad.leerVideojuegos());
                
                for (int i=0;i<d.size();i++) {
    
                System.out.println(
                        d.get(i).getVideojuego_id() + " " 
                        + d.get(i).getNombre_videojuego() + " "
                        + d.get(i).getGenero() + " "
                        + d.get(i).getPrecio_actual() + " "
                        + d.get(i).getPrecio_salida() + " "
                        + d.get(i).getFecha_ultima_actualizacion() + " "
                        + d.get(i).getEstudio_id().getEstudio_id() + " " 
                        + d.get(i).getEstudio_id().getNombre_estudio() + " " 
                        + d.get(i).getEstudio_id().getEmail());
                }
                System.out.println("Pulsa enter para continuar");
                teclado.nextLine();
                ConsolaEstudio.menuVideojuego();
                break;
            case 9:
                logger.trace("Ha vuelto al menu principal");
                 ConsolaEstudio.menu();
                break;
            default:
                logger.trace("Ha introducido una opción erronea");
                System.out.println("Error: el dato no coindice con ninguna de las opciones");
                ConsolaEstudio.menuVideojuego();
            }       
    }
    public static boolean esDoble(String s) {
        try { 
            Double.parseDouble(s);
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
    
    public static boolean esEntero(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        return true;
    }
}
