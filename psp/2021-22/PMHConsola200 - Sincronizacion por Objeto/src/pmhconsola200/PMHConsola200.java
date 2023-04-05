package pmhconsola200;

import java.util.ArrayList;

/**
 * En esta clase se muestra cómo implementar una sección crítica alrededor de un objeto
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMHConsola200 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList();
      
          HiloMujeres h8 = new HiloMujeres(personas);
        h8.start();
        
        
        
        HiloHombres h1 = new HiloHombres(personas);
        h1.start();
        
        HiloMujeres h2 = new HiloMujeres(personas);
        h2.start();
        
           HiloHombres h3 = new HiloHombres(personas);
        h3.start();
           HiloHombres h4 = new HiloHombres(personas);
        h4.start();
           HiloHombres h5 = new HiloHombres(personas);
        h5.start();
           HiloHombres h6 = new HiloHombres(personas);
        h6.start();
        
        
        
        
        
        
    }
    
}
