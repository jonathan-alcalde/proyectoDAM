/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadestudio;

import java.sql.Date;

/**
 *
 * @author usuario
 */
public class Videojuego {
    private Integer videojuego_id;
    private String nombre_videojuego;
    private Estudio estudio_id;
    private char genero;
    private Double precio_salida;
    private Double precio_actual;
    private String version_actual;
    private Date fecha_ultima_actualizacion;
    
    
    /**
     * Constructor vacío de la clase Videojuego
     */
    public Videojuego(){
    
    }
    /**
     * Constructor de la clase Videojuego
     * @param videojuego_id identificador del videojuego
     * @param nombre_videojuego nombre del videojuego
     * @param estudio_id identificador del estudio
     * @param genero género del videojuego
     * @param precio_salida precio de salida del videojuego
     * @param precio_actual precio actual del videojuego
     * @param version_actual version actual del videojuego
     * @param fecha_ultima_actualizacion fecha de la ultima actualizacion sobre el videojeugo
     */
    public Videojuego(Integer videojuego_id, String nombre_videojuego, Estudio estudio_id, char genero, Double precio_salida, Double precio_actual, String version_actual, Date fecha_ultima_actualizacion) {
        this.videojuego_id = videojuego_id;
        this.nombre_videojuego = nombre_videojuego;
        this.estudio_id = estudio_id;
        this.genero = genero;
        this.precio_salida = precio_salida;
        this.precio_actual = precio_actual;
        this.version_actual = version_actual;
        this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
    }
    /**
     * Getter del id del videojuego
     * @return el valor del id del videojuego
     */
    public Integer getVideojuego_id() {
        return videojuego_id;
    }
    /**
     * Setter del id del videojuego
     * @param videojuego_id id del videojuego
     */
    public void setVideojuego_id(Integer videojuego_id) {
        this.videojuego_id = videojuego_id;
    }
    /**
     * Getter del nombre del videojuego
     * @return nombre del videojuego
     */
    public String getNombre_videojuego() {
        return nombre_videojuego;
    }
    /**
     * Setter del nombre del videojuego
     * @param nombre_videojuego nombre del videojuego
     */
    public void setNombre_videojuego(String nombre_videojuego) {
        this.nombre_videojuego = nombre_videojuego;
    }
    /**
     * Getter del estudio del videojuego
     * @return Objeto de la clase Estudio
     */
    public Estudio getEstudio_id() {
        return estudio_id;
    }
    /**
     * Setter del id del estudio
     * @param estudio_id Objeto de la clase Estudio
     */
    public void setEstudio_id(Estudio estudio_id) {
        this.estudio_id = estudio_id;
    }
    /**
     * Getter de genero del videojuego
     * @return genero del videojuego
     */
    public char getGenero() {
        return genero;
    }
    /**
     * Setter del genero del videojuego
     * @param genero genero del videojuego
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }
    /**
     * Getter del precio de salida
     * @return precio de salida del videojuego
     */
    public Double getPrecio_salida() {
        return precio_salida;
    }
    /**
     * Setter del precio de salida del videojuego
     * @param precio_salida precio de salida del videojuego
     */
    public void setPrecio_salida(Double precio_salida) {
        this.precio_salida = precio_salida;
    }
    /**
     * Getter del precio actual del videojuego
     * @return precio actual del videojuego
     */
    public Double getPrecio_actual() {
        return precio_actual;
    }
    /**
     * Setter del precio actual del videojuego
     * @param precio_actual precio actual del videojuego
     */
    public void setPrecio_actual(Double precio_actual) {
        this.precio_actual = precio_actual;
    }
    /**
     * Getter de la version actual del videojuego
     * @return version actual del videojuego
     */
    public String getVersion_actual() {
        return  version_actual;
    }
    /**
     * Setter de la version actual del videojuego
     * @param version_actual version actual del videojuego
     */
    public void setVersion_actual(String version_actual) {
        this.version_actual = version_actual;
    }
    /**
     * Getter de la fecha de la ultima actualizacion del videojuego
     * @return fecha de la ultima actualizacion del videojuego
     */
    public Date getFecha_ultima_actualizacion() {
        return fecha_ultima_actualizacion;
    }
    /**
     * Setter de la fecha de la ultima actualizacion del videojuego
     * @param fecha_ultima_actualizacion fecha de la ultima actualizacion del videojuego
     */
    public void setFecha_ultima_actualizacion(Date fecha_ultima_actualizacion) {
        this.fecha_ultima_actualizacion = fecha_ultima_actualizacion;
    }

  

    
    
    
    
    
}
