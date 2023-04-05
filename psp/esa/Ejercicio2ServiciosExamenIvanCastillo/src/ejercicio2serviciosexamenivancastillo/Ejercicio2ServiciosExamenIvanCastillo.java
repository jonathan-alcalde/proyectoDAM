/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2serviciosexamenivancastillo;

/**
 *
 * @author DAM204
 */
public class Ejercicio2ServiciosExamenIvanCastillo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente c = new Cliente("Jose", "En mi casa hay fuego");    //Creación del cliente Jose que debe ser enviado al servicio de bomberos
        Cliente c2 = new Cliente("Pepe" ,"Hay un ladrón en el supermercado de enfrente de mi casa");    //Creación del cliente Pepe que debe ser enviado al servicio de policia
        Cliente c3 = new Cliente("Juan" ,"Un hombre ha sufrido una caída");     //Creación del cliente Juan que debe ser enviado al servicio del hospital
        Cliente c4 = new Cliente("Pedro" ,"Mi hijo se ha perdido");     //Creacion del cliente Pedro que debe ser enviado al servicio policia ya que no contiene ninguna palabra clave
        Servidor s = new Servidor();    //Creación del objeto servidor que enviara a los clientes a distintos puertos dependiendo de su mensaje
        Bombero b = new Bombero();      //Creación del objeto bombero que atendera las peticiones de los clientes que sean enviados a su puerto por el servidor
        Policia p = new Policia();      //Creación del objeto policia que atendera las peticiones de los clientes que sean enviados a su puerto por el servidor
        Hospital h = new Hospital();    //Creación del objeto hospital que atendera las peticiones de los clientes que sean enviados a su puerto por el servidor
        
        //Inicio de los hilos previamente creados con tiempo de espera de 1 segundo entre los clientes para una mejor visualización
        s.start();
        b.start();
        p.start();
        h.start();
        c.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        c2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        c3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        c4.start();
    }
    
}
