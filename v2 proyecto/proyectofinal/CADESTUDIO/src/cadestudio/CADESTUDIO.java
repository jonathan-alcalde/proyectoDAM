/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadestudio;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Alcalde Usuga
 */
public class CADESTUDIO {
    Connection conexion;
    /**
   * Constructor de la clase CADESTUDIO que contiene la clase jdbc para conectarse a la base de datos
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws SQLException si incumple alguna de las restricciones de la tabla

  */
    
    public CADESTUDIO() throws SQLException, ExcepcionEstudio{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(null);
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(null);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            throw e;
        }
    }
    /**
     * método para conectarse a la base de datos 
     * @throws ExcepcionEstudio 
     */
    private void conectarBD() throws ExcepcionEstudio{
        try{
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "ESTUDIO", "kk");;
        }
         catch(SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(null);
            e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        
    }
    /**
  * Inserta un objeto de la clase Estudio en la Base de datos
  * El objeto al ser obligatorio se lanzará una excepción si es null
  * @param estudio El nuevo objeto que se insertará en la base de datos.
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws SQLException si incumple alguna de las restricciones de la tabla
  * @return registrosAfectos el número de registros que se han añadido a la tabla

  */
    public int insertarEstudio (Estudio estudio) throws ExcepcionEstudio, SQLException { 
     conectarBD();
     int registrosAfectados = 0;
     String llamada = "call insertarESTUDIO(?,?)";
     CallableStatement cs = conexion.prepareCall(llamada);
        try {
            cs.setString(1,estudio.getNombre_estudio());
            cs.setString(2,estudio.getEmail());
            registrosAfectados = cs.executeUpdate();
            System.out.println("Registros Afectados: " + registrosAfectados);
            cs.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(llamada);
            switch (ex.getErrorCode()){
                    case 1400:
                        e.setMensajeErrorUsuario("Todos los campos son obligatorios");
                        break;
                    case 00001:
                        e.setMensajeErrorUsuario("El nombre del estudio y el email no se pueden repetir");
                        break;
                    case 2290:
                        e.setMensajeErrorUsuario("El email debe tener @ ");
                        break;
                    default:
                        e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");                        
            } 
            throw e;
        }
        return registrosAfectados;
    }
    
    /**
  * Elimina un registro de la tabla ESTUDIO.
  * Al ser el estudioId, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param estudioId El ID del objeto que se eliminará.
  * @return numero de registros afectados
  * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.
  * @throws ExcepcionEstudio si no se encuentra la clase
  */
    public int eliminarEstudio(Integer estudioId) throws ExcepcionEstudio{
        conectarBD();
        String dml = "delete from ESTUDIO where ESTUDIO_ID=" + estudioId;
        int registrosAfectados = 0;
        try{
            Statement sentencia = conexion.createStatement();
            registrosAfectados = sentencia.executeUpdate(dml);
            System.out.println("Registros Afectados: " + registrosAfectados);
            sentencia.close();
            conexion.close();
        }
        catch (SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()){
                case 2292: e.setMensajeErrorUsuario("No se puede eliminar el estudio porque tiene videojuegos asociados");
                    break;
                
                default: e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }   
            throw e;
        }
        return registrosAfectados;
    }
    /**
  * Actualiza un registro de la tabla Estudio
  * Al ser el objeto, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param estudio Los datos del nuevo estudio.
  * @return numero de registros afectados
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
  */
    public int actualizarEstudio(Estudio estudio) throws ExcepcionEstudio, SQLException{
        conectarBD();
        String dml = "UPDATE ESTUDIO SET "
                + "NOMBRE_ESTUDIO = ?,"
                + "EMAIL = ? "
                + "WHERE ESTUDIO_ID = ?";
        int registrosAfectados = 0;
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setString(1, estudio.getNombre_estudio());
            sentenciaPreparada.setString(2, estudio.getEmail());
            sentenciaPreparada.setInt(3,estudio.getEstudio_id());
            registrosAfectados =  sentenciaPreparada.executeUpdate();
            System.out.println("Registros Afectados: " + registrosAfectados );
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()){
                    case 0001:
                        e.setMensajeErrorUsuario("El nombre y el email del  no se puede repetir");
                        break;
                    case 1407:
                        e.setMensajeErrorUsuario("Todos los campos son obligatorios");
                        break;
                    case 2290:
                        e.setMensajeErrorUsuario("El email debe tener @");
                    case 2292:
                        e.setMensajeErrorUsuario("No se puede cambiar el identificador del estudio, porque tiene videojuegos asociados");
                        break;
                    default:
                        e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");                        
            }        
            throw e;
        }
        return registrosAfectados;
    }
    /**
  * Inserta un objeto de la clase videojuego en la tabla Videojuego.
  * 
  *
  * @param videojuego El nuevo videojuego.
    @return numero de registros afectados 
  * @throws IllegalArgumentException Si es null, está vacío o contiene sólo espacios.
  * @throws ExcepcionEstudio si no se encuentra la clase
  */
    public int insertarVideojuego(Videojuego videojuego) throws ExcepcionEstudio{
        conectarBD();
        String maniobra;
        String dml = "insert into VIDEOJUEGO(videojuego_id,nombre_videojuego,estudio_id,genero,precio_salida,precio_actual,version_actual)" + "values(seq_videojuego.nextval,?,?,?,?,?,?)";
        int registrosAfectados;
        
        
        try {
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setString(1,videojuego.getNombre_videojuego());
            sentenciaPreparada.setObject(2,videojuego.getEstudio_id().getEstudio_id());
            sentenciaPreparada.setString(3,String.valueOf(videojuego.getGenero()));
            sentenciaPreparada.setDouble(4,videojuego.getPrecio_salida());
            sentenciaPreparada.setDouble(5,videojuego.getPrecio_actual());
            sentenciaPreparada.setString(6,videojuego.getVersion_actual());
            registrosAfectados = sentenciaPreparada.executeUpdate();
            System.out.println("Registros Afectados: " + registrosAfectados);
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()){    
                    case 1400:
                        e.setMensajeErrorUsuario("El nombre del videojuego, el identificador del estudio, el genero, el precio de salida y la versión son obligatorias");
                        break;
                    case 1403:
                        e.setMensajeErrorUsuario("El estudio no existe");
                        break;
                    case 20004:
                        e.setMensajeErrorUsuario("El nombre del estudio y del videojuego no pueden ser el mismo");
                        break;
                    case 2290:
                        e.setMensajeErrorUsuario("El precio actual debe de ser menor o igual al precio de salida, y no pueden ser menor que 0");
                        break;
                    default:
                        e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");                        
            }        
            throw e;
        }
        return 0;
    }
    /**
  * Elimina un videojuego de la tabla Videojuegos.
  * Al ser el videojuegoId boligatorio, si es nulo o vacío se lanzará
  * una excepción
  *
  * @param videojuegoId El id del videojuego que se eliminará.
  * @return numero de registros afectados
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.

  */
    public int eliminarVideojuego(Integer videojuegoId) throws ExcepcionEstudio{
        conectarBD();
        String dml = "delete from VIDEOJUEGO where VIDEOJUEGO_ID=" + videojuegoId;
        int registrosAfectados = 0;
        try{
            Statement sentencia = conexion.createStatement();
            registrosAfectados = sentencia.executeUpdate(dml);
            System.out.println("Registros Afectados: " + registrosAfectados);
            sentencia.close();
            conexion.close();
        }
        catch (SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dml);
            switch (ex.getErrorCode()){
                default: e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");
            }
            throw e;
//                System.out.println("Error SQL: " + ex.getErrorCode() + " - " + ex.getMessage());
                
        }
        return registrosAfectados; 
    }
    
    /**
  * Actualiza un videojuego de la tabla videojuego.
  * Al ser el videojuego, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param videojuego El videojuego que se actualizará.
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
  * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.
  * @return int con tod
  */
    public int actualizarVideojuego(Videojuego videojuego) throws ExcepcionEstudio, SQLException{
     conectarBD();
     int registrosAfectados = 0;
     String llamada = "call ACTUALIZARVIDEOJUEGO(?,?,?,?,?,?,?)";
     
        try {
            CallableStatement cs = conexion.prepareCall(llamada);
            cs.setInt(1,videojuego.getVideojuego_id());
            cs.setString(2,videojuego.getNombre_videojuego());
            cs.setObject(3, videojuego.getEstudio_id().getEstudio_id());
            cs.setString(4, String.valueOf(videojuego.getGenero()));
            cs.setDouble(5,videojuego.getPrecio_salida());
            cs.setDouble(6,videojuego.getPrecio_actual());
            cs.setString(7,videojuego.getVersion_actual());
            registrosAfectados = cs.executeUpdate();
            System.out.println("Registros Afectados: " + registrosAfectados);
            cs.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(llamada);
            switch (ex.getErrorCode()){
                    case 1400:
                        e.setMensajeErrorUsuario("El nombre del videojuego, el identificador del estudio, el genero, el precio de salida y la versión son obligatorias");
                        break;
                    case 1403:
                        e.setMensajeErrorUsuario("El estudio no existe");
                    case 20004:
                        e.setMensajeErrorUsuario("El nombre del estudio y del videojuego no pueden ser el mismo");
                        break;
                    case 2290:
                        e.setMensajeErrorUsuario("El precio actual debe de ser menor o igual al precio de salida, y no pueden ser menor que 0");
                        break;
                    default:
                        e.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador");                        
            }        
            throw e;
        }
        return registrosAfectados;
    }
    /**
  * Devuelve un objeto de la clase ESTUDIO
  * Al ser el estudio_id obligatorio, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param estudio_id El identificador del estudio.
  * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
  * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.
  * @return Estudio objeto de la clase Estudio con la información del usuario del que se ha introducido el id
  */
    public Estudio leer1estudio(int estudio_id) throws ExcepcionEstudio, SQLException{
        conectarBD();
        Estudio s = new Estudio();
        String dql = "select * from ESTUDIO  where estudio_id = ? ";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(dql);
        sentenciaPreparada.setInt(1,estudio_id);
        ResultSet resultado = sentenciaPreparada.executeQuery();
        try{  
            while(resultado.next()){
                s.setEstudio_id(resultado.getInt("ESTUDIO_ID"));
                s.setNombre_estudio(resultado.getString("NOMBRE_ESTUDIO"));
                s.setEmail(resultado.getString("EMAIL"));
             }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        }
        catch(SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql);
            System.out.println("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        return s;
       }
   /**
  * Devuelve un objeto de la clase Videojuego
  * Al ser videojuego_id obligatorio, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param videojuego_id El identificador del videojuego.
    * @return objeto Videojuego con la información extraida de la base de datos Videojugo
    * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
    * @throws java.io.IOException si hay algun error de ejecucción
    * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.
  * 

  */
    public Videojuego leer1Videojuego(int videojuego_id) throws ExcepcionEstudio, SQLException, IOException{
        conectarBD();
        Videojuego v = new Videojuego();
        Estudio s = new Estudio();
        String dql = "select * from videojuego v, estudio e where v.estudio_id = e.estudio_id and v.videojuego_id= ?";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(dql);
        sentenciaPreparada.setInt(1,videojuego_id);
        ResultSet resultado = sentenciaPreparada.executeQuery();
        
        try{
             while(resultado.next()){
            v.setVideojuego_id(resultado.getInt("VIDEOJUEGO_ID"));
            v.setNombre_videojuego(resultado.getString("NOMBRE_VIDEOJUEGO"));
            v.setGenero(resultado.getString("genero").charAt(0));
            v.setPrecio_salida(resultado.getDouble("precio_salida"));
            v.setPrecio_actual(resultado.getDouble("precio_actual"));
            v.setVersion_actual(resultado.getString("version_actual"));
            v.setFecha_ultima_actualizacion(resultado.getDate("fecha_ultima_actualizacion"));
            
            s.setEstudio_id(resultado.getInt("estudio_id"));
            s.setNombre_estudio(resultado.getString("nombre_Estudio"));
            s.setEmail(resultado.getString("email"));
            v.setEstudio_id(s);
            
             }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        }
        catch(SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql);
            System.out.println("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        return v;
    }
    /**
  * Devuelve ArrayList que contiene objetos de la clase Estudio que se encuentren en la tabla Estudio.
  * El método no necesita ningún parametro
     * @return ArrayList "Estudio" formado por los objetos Estudio que se encuentran en la tabla Estudio
     * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
  */
    public ArrayList<Estudio> leerEstudios() throws ExcepcionEstudio, SQLException{
        conectarBD();
        ArrayList<Estudio> l  = new ArrayList();
        String dql = "select * from estudio";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(dql);
        try{  
            while(resultado.next()){
                Estudio s = new Estudio();
                s.setEstudio_id(resultado.getInt("ESTUDIO_ID"));
                s.setNombre_estudio(resultado.getString("NOMBRE_ESTUDIO"));
                s.setEmail(resultado.getString("EMAIL"));
                l.add(s);
                System.out.println(s.getEstudio_id() + " " + s.getNombre_estudio() + " " + s.getEmail());
                
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        }
        catch(SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql);
            System.out.println("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        return l;
    }
   /**  
    * Devuelve ArrayList que contiene objetos de la clase Estudio que se encuentren en la tabla Estudio.
  * El método no necesita ningún parametro
  * 
     * @return Devuelve un arraylist que contiene los objetos Videojuego que se encuentran en la tabla
     * @throws ExcepcionEstudio si no se encuentra la clase
  * @throws java.sql.SQLException si el nuevo objeto estudio incumple alguna restricción de la tabla
  */
    public ArrayList<Videojuego> leerVideojuegos() throws ExcepcionEstudio, SQLException{
        conectarBD();
        ArrayList<Videojuego> l  = new ArrayList();
        Videojuego v = new Videojuego();
        String dql = "select * from videojuego v, estudio e where v.estudio_id = e.estudio_id";
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(dql);
        try{  
            
            while(resultado.next()){
                v.setVideojuego_id(resultado.getInt("videojuego_id"));
                v.setNombre_videojuego(resultado.getString("nombre_videojuego"));
                v.setGenero(resultado.getString("genero").charAt(0));
                v.setPrecio_salida(resultado.getDouble("precio_salida"));
                v.setPrecio_actual(resultado.getDouble("precio_actual"));
                v.setVersion_actual(resultado.getString("version_actual"));
                v.setFecha_ultima_actualizacion(resultado.getDate("fecha_ultima_actualizacion"));
                Estudio s = new Estudio();
                s.setEstudio_id(resultado.getInt("estudio_id"));
                s.setNombre_estudio(resultado.getString("nombre_Estudio"));
                s.setEmail(resultado.getString("email"));
                v.setEstudio_id(s);
                l.add(v);
                System.out.println(v.getVideojuego_id() + " " 
                    + v.getNombre_videojuego() + " "
                    + v.getGenero() + " "
                    + v.getPrecio_actual() + " "
                    + v.getPrecio_salida() + " "
                    + v.getFecha_ultima_actualizacion() + " "
                    + v.getEstudio_id().getEstudio_id() + " " 
                    + v.getEstudio_id().getNombre_estudio() + " " 
                    + v.getEstudio_id().getEmail());
             }
            resultado.close();
            sentencia.close();
            conexion.close();
        }
        catch(SQLException ex){
            ExcepcionEstudio e = new ExcepcionEstudio();
            e.setCodigoError(ex.getErrorCode());
            e.setMensajeErrorBD(ex.getMessage());
            e.setSentenciaSQL(dql);
            System.out.println("Error general del sistema. Consulte con el administrador");
            throw e;
        }
        return l;
    }
}      
