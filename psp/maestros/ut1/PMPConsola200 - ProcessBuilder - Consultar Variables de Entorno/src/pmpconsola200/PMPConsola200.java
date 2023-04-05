package pmpconsola200;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * En esta clase se muestra:
 *  1. Cómo consultar las variables de entorno de MSDOS
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola200 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        HashMap variablesEntorno = (HashMap<String,String>) pb.environment();
        System.out.println(variablesEntorno.get("Path"));
        
        Set s = variablesEntorno.entrySet();
        Entry e;
        Iterator i = s.iterator();
        while (i.hasNext()) {
            e = (Entry) i.next();
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
    
}
