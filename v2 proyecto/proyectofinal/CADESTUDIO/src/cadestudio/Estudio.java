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

/**
 * 
 * @author usuario
 */
public class Estudio {
    private int estudio_id;
    private String nombre_estudio;
    private String email;
    
   /**
    * Constructor vacio de la clase Estudio
    */
    public Estudio(){
    }
    /**
     * Constructor de la clase Estudio
     * @param estudio_id id de Estudio
     * @param nombre_estudio nombre de Estudio
     * @param email email de Estudio
     */
    public Estudio(int estudio_id,String nombre_estudio,String email){
        this.estudio_id = estudio_id;
        this.nombre_estudio = nombre_estudio;
        this.email = email;
    }
    /**
     * Getter del id de estudio
     * @return id del estudio
     */

    public int getEstudio_id() {
        return estudio_id;
    }
    /**
     * Setter del estudio _id
     * @param estudio_id id del estudio
     */
    public void setEstudio_id(int estudio_id) {
        this.estudio_id = estudio_id;
    }
    /**
     * Getter del nombre del estudio
     * @return nombre del estudio
     */
    public String getNombre_estudio() {
        return nombre_estudio;
    }
    /**
     * Setter del nombre del estudio
     * @param nombre_estudio nombre del estudio
     */
    public void setNombre_estudio(String nombre_estudio) {
        this.nombre_estudio = nombre_estudio;
    }
    /**
     * Getter del email del estudio
     * @return email del Estudio
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter del email del estudio
     * @param email email del Estudio
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}

