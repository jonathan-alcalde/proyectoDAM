import java.util.Scanner;

public class Pregunta{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dime tu nombre: ");
        String t = teclado.nextLine();
	System.out.println("Hola " + t);
    }
    
}
