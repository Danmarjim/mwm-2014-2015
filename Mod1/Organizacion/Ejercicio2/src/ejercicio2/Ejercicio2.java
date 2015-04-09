package ejercicio2;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class Ejercicio2 {
    
    public static void main(String [] args){
        
        //Almacenar en un vector las cadenas que se introducen por teclado.
        
        Vector v = new Vector();
        
        Scanner tcld = new Scanner(System.in);
        String s = tcld.nextLine();
        while(!s.equals("")){
            v.addElement(s);
            s = tcld.nextLine();
        }
        
        System.out.println("Todas las cadenas que se han leido son: ");
        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            s = (String) e.nextElement();
            System.out.println(s);
        }
        
        System.out.println("Cadenas con cinco o mas caracteres");
        Enumeration e2 = v.elements();
        while(e2.hasMoreElements()){
            s = (String) e2.nextElement();
            if(s.length()>=5){
                System.out.println(s);
            } 
        }
        
        System.out.println("Cadenas en posiciones pares");
        int i = 1;
        Enumeration e3 = v.elements();
        while(e3.hasMoreElements()){
            s = (String) e3.nextElement();
            if(i%2 == 0){
                System.out.println(s);
            }
            i++;
        }
        
        System.out.println("Mostrando vector en orden inverso");
            
    }
}
