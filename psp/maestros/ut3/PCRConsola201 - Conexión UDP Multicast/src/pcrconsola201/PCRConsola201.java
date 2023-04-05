package pcrconsola201;

/**
 *
 * @author usuario
 */
public class PCRConsola201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread servidor = new Servidor();
        Thread cliente1 = new Cliente("Pepe");
        Thread cliente2 = new Cliente("Luis");
        Thread cliente3 = new Cliente("Ana");
        
        servidor.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
    }
    
}
