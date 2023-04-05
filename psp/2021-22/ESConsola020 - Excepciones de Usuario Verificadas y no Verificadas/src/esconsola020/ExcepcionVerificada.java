package esconsola020;

/**
 * En esta clase crea una clase denominada ExcepcionVerificada que hereda de la clase Exception
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ExcepcionVerificada extends Exception {

    /**
     * Constructor de la clase
     * @param mensaje Mensaje a retornar cuando la excepción se produce
    */
    public ExcepcionVerificada (String mensaje) {
        super(mensaje);
    }
}
