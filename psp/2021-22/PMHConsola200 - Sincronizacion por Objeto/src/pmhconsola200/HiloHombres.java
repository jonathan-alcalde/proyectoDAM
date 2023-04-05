package pmhconsola200;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase implementa un hilo que almacena una lista de hombres sobre un arraylist externo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class HiloHombres extends Thread {
    final ArrayList<Persona> hombres;

    /**
     * Constructor que pèrmite inicializar el hilo con el objeto en el que guardar la lista de hombres
     * @param hombres ArrayList sobre el que almacenar la Lista de hombres
    */
    public HiloHombres(ArrayList<Persona> hombres) {
        this.hombres = hombres;
    }
    
    /**
     * Método que implementa el comportamiento del hilo. Añade 4 hombres a la lista de hombres y muestra 
     * dicha lista
    */
    @Override
    public void run() {
        synchronized(hombres) {
            hombres.add(new Persona("01","Angel","Ruiz","Pérez"));
            hombres.add(new Persona("02","Luis","Pérez","Ruiz"));
            hombres.add(new Persona("03","Miguel","Gómez","Ruiz"));
            hombres.add(new Persona("04","Juan","Pi","Pi"));
            Iterator<Persona> i = hombres.iterator();
            while (i.hasNext()) {
                Persona p = i.next();
                System.out.println(p.cif + " " + p.nombre + " " + p.apellido1 + " " + p.apellido2);
            }
        }
    }
    
}
