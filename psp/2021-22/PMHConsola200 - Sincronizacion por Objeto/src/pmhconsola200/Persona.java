package pmhconsola200;

/**
 * Esta clase representa a una persona, con algunos de sus datos personales
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Persona {
    String cif;
    String nombre;
    String apellido1;
    String apellido2;

    /**
     * Constructor que pèrmite inicializar la clase con el cif, nombre y apellidos de la persona
     * @param cif CIF de la persona
     * @param nombre Nombre de la persona
     * @param apellido1 Primer apellido de la persona
     * @param apellido2 Segundo apellido de la persona
    */
    public Persona(String cif, String nombre, String apellido1, String apellido2) {
        this.cif = cif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método que devuelve el cif de la persona
     * @return CIF de la persona
    */
    public String getCif() {
        return cif;
    }

    /**
     * Método que asigna el cif a la persona
     * @param cif CIF de la persona
    */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * Método que devuelve el nombre de la persona
     * @return Nombre de la persona
    */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna el nombre a la persona
     * @param nombre Nombre de la persona
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el primer apellido de la persona
     * @return Primer apellido de la persona
    */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Método que asigna el primer apellido a la persona
     * @param apellido1 Primer apellido de la persona
    */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Método que devuelve el segundo apellido de la persona
     * @return Segundo apellido de la persona
    */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Método que asigna el segundo apellido a la persona
     * @param apellido2 Segundo apellido de la persona
    */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
}
