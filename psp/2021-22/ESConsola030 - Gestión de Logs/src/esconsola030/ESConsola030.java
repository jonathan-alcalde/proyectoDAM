package esconsola030;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

/**
 * En esta clase se muestra:
 *  1. Cómo gestionar ficheros de logs a través de la librería log4j
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola030 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        System.out.println("Hola ...");
        PropertyConfigurator.configure("maniobra\\log4j.properties");
        Logger logger = LogManager.getLogger("NAVEGACION");
        logger.trace("Esto es un trace");
        logger.warn("Esto es un warning");
        logger.error("Esto es un error");
        logger.fatal("Esto es un fatal");
        logger.info("Esto es un info"); 
    }

}
