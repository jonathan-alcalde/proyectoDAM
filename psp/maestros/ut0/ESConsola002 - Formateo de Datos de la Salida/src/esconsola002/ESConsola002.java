package esconsola002;

import java.util.Date;

/**
 * En esta clase se muestra:
 *  1. Cómo formatear la salida de datos con caracteres de conversión (s, f, d, t)
 *  2. Cómo formatear la salida de datos de tipo fecha con caracteres de sufijo de conversión (A, B, Y ...)
 *  3. Cómo manejar caracteres especiales (\, %, salto de línea ...)
 *  4. Cómo manejar banderas de la cadena de formato (+, #, 0, (  ...)
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since AaD 1.0
 * @since PSP 1.0
*/
public class ESConsola002 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        String nombre = "Carlos Ruiz Calvo";
        int tallaZapato = 12345;
        double sueldo = 24532.54;
        Date fechaActual = new Date();
        
        System.out.printf("Nombre: %s \n",nombre);
        System.out.printf("Nombre: %S \n",nombre);
        System.out.printf("Talla de Zapato: %d \n",tallaZapato);
        System.out.printf("Sueldo: %f \n",sueldo);
        
        System.out.printf("Alinear a la derecha un texto: %30s \n",nombre);
        System.out.printf("Alinear a la derecha un texto: %30s \n","Ana Ruiz Ruiz");
        System.out.printf("Alinear a la derecha un texto: %30s \n","Javier Cea Cosculluela");
        
        System.out.printf("Alinear a la izquierda un texto: %s \n",nombre);
        System.out.printf("Alinear a la izquierda un texto: %s \n","Ana Ruiz Ruiz");
        System.out.printf("Alinear a la izquierda un texto: %s \n","Javier Cea Cosculluela");
        
        System.out.printf("Fecha/Hora Actual: %tc \n",fechaActual);
        System.out.printf("Fecha/Hora Actual: %Tc \n",fechaActual);

        System.out.printf("Fecha Actual: %tF \n",fechaActual);
        System.out.printf("Fecha Actual: %tD \n",fechaActual);
        
        System.out.printf("Hora Actual: %tr \n",fechaActual);
        System.out.printf("Hora Actual: %tR \n",fechaActual);
        System.out.printf("Hora Actual: %tT \n",fechaActual);
        
        System.out.printf("Día de la Semana: %tA \n",fechaActual);
        System.out.printf("Día de la Semana: %ta \n",fechaActual);
        System.out.printf("Mes: %tB \n",fechaActual);
        System.out.printf("Mes: %tb \n",fechaActual);
        System.out.printf("Año: %tY \n",fechaActual);
        System.out.printf("Año: %ty \n",fechaActual);
        System.out.printf("Hora: %tH \n",fechaActual);
        System.out.printf("Minutos: %tM \n",fechaActual);
        System.out.printf("Segundos: %tS \n",fechaActual);

        System.out.printf("Fecha: %1$tA-%1$tB-%1$tY \n",fechaActual);

        System.out.printf("Porcentaje: 25%% \n");
        System.out.printf("Primera línea%nSegunda línea \n");
        System.out.printf("Crear un \t tabulador \n");
        System.out.printf("Crear una barra inversa \\ tabulador \n");
        System.out.printf("La palabra \"Clue\" es la clave \n");
        
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",1);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",12);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",123);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",1234);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",12345);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",123456);
        System.out.printf("Ajustar a 4 posiciones un entero: %4d \n",1234567);
        
        System.out.printf("Ajustar a 4 posiciones enteras y 3 decimales: %4.3f \n",12.34567);
        System.out.printf("Ajustar a 4 posiciones enteras y 4 decimales: %4.4f \n",12.34567);
        System.out.printf("Ajustar a 4 posiciones enteras y 5 decimales: %4.5f \n",12.34567);
        
        System.out.printf("Alinear por la coma decimal: %10.2f \n",12.34567);
        System.out.printf("Alinear por la coma decimal: %10.2f \n",33312.3);
        System.out.printf("Alinear por la coma decimal: %10.2f \n",142.345);
        
        System.out.printf("Mostrar siempre el signo: %+d \n",142);
        System.out.printf("Mostrar siempre el signo: %+d \n",-142);
        
        System.out.printf("Mostrar solo el signo negativo: %d \n",142);
        System.out.printf("Mostrar solo el signo negativo: %d \n",-142);
        
        System.out.printf("Mostrar entre paréntesis los valores negativos: %(d \n",142);
        System.out.printf("Mostrar entre paréntesis los valores negativos: %(d \n",-142);
        
        System.out.printf("Mostrar solo el signo negativo: %09d \n",142);
        System.out.printf("Mostrar solo el signo negativo: %06d \n",-142);
        
    }
    
}
