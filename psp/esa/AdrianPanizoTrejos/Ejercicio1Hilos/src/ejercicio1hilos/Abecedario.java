/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1hilos;

/**
 *
 * @author Adrian Panizo
 */
public class Abecedario {
    private char[] abecedario;
    
    /*
    Constructor de la clase. Inicializa un abecedario de la A a la Z
    */
    public Abecedario() {
        abecedario = new char[27];
        for(int i = 0; i < 27; i++) {
            char letra = '.';
            switch(i) {
                case 0:
                    letra = 'A';
                    break;
                case 1:
                    letra = 'B';
                    break;
                case 2:
                    letra = 'C';
                    break;
                case 3:
                    letra = 'D';
                    break;
                case 4:
                    letra = 'E';
                    break;
                case 5:
                    letra = 'F';
                    break;
                case 6:
                    letra = 'G';
                    break;
                case 7:
                    letra = 'H';
                    break;
                case 8:
                    letra = 'I';
                    break;
                case 9:
                    letra = 'J';
                    break;
                case 10:
                    letra = 'K';
                    break;
                case 11:
                    letra = 'L';
                    break;
                case 12:
                    letra = 'M';
                    break;
                case 13:
                    letra = 'N';
                    break;
                case 14:
                    letra = 'Ñ';
                    break;
                case 15:
                    letra = 'O';
                    break;
                case 16:
                    letra = 'P';
                    break;
                case 17:
                    letra = 'Q';
                    break;
                case 18:
                    letra = 'R';
                    break;
                case 19:
                    letra = 'S';
                    break;
                case 20:
                    letra = 'T';
                    break;
                case 21:
                    letra = 'U';
                    break;
                case 22:
                    letra = 'V';
                    break;
                case 23:
                    letra = 'W';
                    break;
                case 24:
                    letra = 'X';
                    break;
                case 25:
                    letra = 'Y';
                    break;
                case 26:
                    letra = 'Z';
                    break;
                
            }
            abecedario[i] = letra;
        }
    }
    
    synchronized public void mostrar() {
        for (int i = 0; i<27; i++) System.out.print(abecedario[i] + "-");
        System.out.println("Fin");
    }
    
    
}
