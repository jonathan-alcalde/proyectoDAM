/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadestudio;

/**
 *
 * @author Jonathan Alcalde Usuga
 */
public class ExcepcionEstudio  extends Exception{
    private Integer codigoError;
    private String mensajeErrorBD;
    private String mensajeErrorUsuario;
    private String sentenciaSQL;
    /**
     * Constructor vacio de la clase Excepcion Estudio
     */
    public ExcepcionEstudio() {
    }
    /**
     * Constructor de la clase Excepcion Estudio
     * @param codigoError codigo del error
     * @param mensajeErrorBD mensaje de error de la base de datos
     * @param mensajeErrorUsuario mensaje de error del usuario
     * @param sentenciaSQL mensaje con la sentencia SQL introducida
     */
    public ExcepcionEstudio(Integer codigoError, String mensajeErrorBD, String mensajeErrorUsuario, String sentenciaSQL) {
        this.codigoError = codigoError;
        this.mensajeErrorBD = mensajeErrorBD;
        this.mensajeErrorUsuario = mensajeErrorUsuario;
        this.sentenciaSQL = sentenciaSQL;
    }
    /**
     * Getter del codigo de error
     * @return codigo del error
     */
    public Integer getCodigoError() {
        return codigoError;
    }
    /**
     * Setter del codigo de error
     * @param codigoError codigo del error
     */
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }
    /**
     * Getter del mensaje de Error de la base de datos
     * @return mensaje del error de la base de datos
     */
    public String getMensajeErrorBD() {
        return mensajeErrorBD;
    }
    /**
     * Setter del mensaje de Error de la base de datos
     * @param mensajeErrorBD mensaje de error de la base de datos- 
     */
    public void setMensajeErrorBD(String mensajeErrorBD) {
        this.mensajeErrorBD = mensajeErrorBD;
    }
    /**
     * Getter del mensaje de error del usuario
     * @return  mensaje de error del usuario
     */
    public String getMensajeErrorUsuario() {
        return mensajeErrorUsuario;
    }
    /**
     * Setter del mensaje de error del usuario
     * @param mensajeErrorUsuario  mensaje de error del usuario
     */
    public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
    }
    /**
     * Getter de la sentencia sql
     * @return Sentencia SQL
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }
    /**
     * Setter de la sentencia sql
     * @param sentenciaSQL  sentencia SQL
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }


    /**
     * Método que devuelve un String con la información del error
     * @return String con la información del error
     */
    @Override
    public String toString() {
        return "ExcepcionEstudio{" + "codigoError=" + codigoError + ", mensajeErrorBD=" + mensajeErrorBD + ", mensajeErrorUsuario=" + mensajeErrorUsuario + ", sentenciaSQL=" + sentenciaSQL + '}';
    }
    
}
