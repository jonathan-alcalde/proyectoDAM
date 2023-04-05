package esconsola010;

/**
 * En esta clase se muestra:
 *  1. Cómo pasarle parámetros de diferentes tipos a una aplicación
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola010 {

    /**
     * Método principal de la clase
     * @param args Recibe los siguientes parámetros:
     *  1. args[0] Una cadena de texto
     *  2. args[1] Un número entero
    */
    public static void main(String[] args) {
        String s;
        int i;
        
        s = args[0];
        i = Integer.valueOf(args[1]);
        
        System.out.println(s + " " + i);
    }
    
}
