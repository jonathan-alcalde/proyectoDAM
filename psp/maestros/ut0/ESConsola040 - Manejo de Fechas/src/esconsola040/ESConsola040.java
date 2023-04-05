/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esconsola040;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ifhprof01
 */
public class ESConsola040 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(2016, 8, 25, 18, 50);
        System.out.println(gc.get(Calendar.DAY_OF_WEEK));
        System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.get(Calendar.HOUR));
        System.out.println(gc.get(Calendar.AM_PM));
        System.out.println(Calendar.AM);
        System.out.println(Calendar.PM);
        System.out.println(gc.get(Calendar.YEAR));
        
    }
    
}
