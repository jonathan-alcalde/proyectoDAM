package esconsola020;

/**
 * En esta clase crea una clase denominada ExcepcionNoVerificada que hereda de la clase RuntimeException
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ExcepcionNoVerificada extends RuntimeException {

    /**
     * Constructor de la clase
     * @param mensaje Mensaje a retornar cuando la excepción se produce
    */
    public ExcepcionNoVerificada (String mensaje) {
        super(mensaje);
    }
}
