package ejercicio4;

import java.util.Vector;

public class Ejercicio4 {
    
    public static void main(String[] args){
        
        //Crear un vector de los primeros numeros naturales
        Vector v = new Vector();
        Vector v2 = new Vector();
        
        for(int i = 0; i != 10; i++){
            v.addElement(i);            
        }
        System.out.println("El vector sera el siguiente: " +v);
        
        for(int k = v.size()-1; k != -1; --k){
            v2.addElement(k);
        }
        System.out.println("El vector ordenado en orden inverso: " +v2);
    }
    
}
