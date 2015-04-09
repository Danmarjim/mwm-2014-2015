package ejercicio3;

import java.util.Random;
import java.util.Vector;

public class Ejercicio3 {
    
    public static void main(String [] args){
        
        Vector v = new Vector();   
        Vector v2 = new Vector();
        Vector v3 = new Vector();
        Vector v4 = new Vector();
        
        //Primero 10 numeros enteros
        int i = 0;
        while(i!=10){
            v.addElement(i);
            i++;
        }        
        System.out.println("Primero 10 numeros enteros " +v);  
        
        //10 numero naturales entre 1201 y 1210
        int i2 = 1201;
        while(i2!=1210){
            v2.addElement(i2);
            i2++;
        }        
        System.out.println("10 numero naturales entre 1201 y 1210 "+ v2);
        
        //Llenar un vector con valores aleatorios entre 10 y 20
        Random r = new Random();        
        int n, i3 = 0, base = 10;
        Integer in;
        while(i3!=10){
            n = base + r.nextInt(11);
            in = new Integer(n);
            v3.addElement(in);
            i3++;
        }        
        System.out.println("Llenar un vector con valores aleatorios entre 10 y 20 "+v3);
        
        //Llenar un vector con valores aleatorios entre 2500 y 2550
        Random r2 = new Random();        
        int n2, i4 = 0, base2 = 2500;
        Integer in2;
        while(i4!=10){
            n2 = base2 + r2.nextInt(51);
            in2 = new Integer(n2);
            v4.addElement(in2);
            i4++;
        }        
        System.out.println("Llenar un vector con valores aleatorios entre 2500 y 2550 " +v4);
    }
    
}
