package pmhconsola200;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase implementa un hilo que almacena una lista de mujeres sobre un arraylist externo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class HiloMujeres extends Thread {
    final ArrayList<Persona> mujeres;

    /**
     * Constructor que pèrmite inicializar el hilo con el objeto en el que guardar la lista de mujeres
     * @param mujeres ArrayList sobre el que almacenar la Lista de mujeres
    */
    public HiloMujeres(ArrayList<Persona> mujeres) {
        this.mujeres = mujeres;
    }
    
    /**
     * Método que implementa el comportamiento del hilo. Añade 4 mujeres a la lista de mujeres y muestra 
     * dicha lista
    */
    @Override
    public void run() {
        synchronized(mujeres) {
            mujeres.add(new Persona("01","Ana","Ruiz","Pérez"));
            mujeres.add(new Persona("02","Pepa","Pérez","Ruiz"));
            mujeres.add(new Persona("03","Eva","Gómez","Ruiz"));
            mujeres.add(new Persona("04","Lidia","Pi","Pi"));
            Iterator<Persona> i = mujeres.iterator();
            while (i.hasNext()) {
                Persona p = i.next();
                System.out.println(p.cif + " " + p.nombre + " " + p.apellido1 + " " + p.apellido2);
            }
        }
    }
    
}
