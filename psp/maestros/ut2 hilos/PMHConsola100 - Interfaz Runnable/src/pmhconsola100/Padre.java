package pmhconsola100;

/**
 * Esta clase no tiene ningún significado de negocio. Se usa como clase padre de otra
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class Padre {
    int a;
    
    /**
     * Constructor que pèrmite inicializar el atributo a
     * @param a Atributo de la clase
    */
    Padre(int a) {
        this.a = a;
    }

    /**
     * Método que pèrmite obtener el atributo a
    */
    public int getA() {
        return a;
    }

    /**
     * Constructor que pèrmite asignar un valor al atributo a
     * @param a Atributo de la clase
    */
    public void setA(int a) {
        this.a = a;
    }
    
}
