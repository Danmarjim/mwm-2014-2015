package evaluacion1;

import java.util.Vector;

/**
 * Clase que contiene el metodo main para utilizar los metodos creados en MiVector
 */

public class Main {
    
    public static void main(String[] args){
        
        MiVector v = new MiVector();
        MiVector v2 = new MiVector();
                
        int res = v.valorMayor();
        int res2 = v.valorMenor();
        int res3 = v.valorMediana();
        int res4 = v.posicionValorMayor();
        int res5 = v.valorMedia();
        
        boolean resultado = v.equals(v2);
        
        System.out.println("Pintar vector: " +v);
        System.out.println("Pintar vector: " +v2);
        System.out.println("Valor mayor del vector: " +res);
        System.out.println("Valor menor del vector: " +res2);
        System.out.println("Valor que se encuentra en la mitad del vector: " +res3);
        System.out.println("Posicion del mayor valor del Vector: " +res4);
        System.out.println("Valor media del Vector: " +res5);
        System.out.println("¿Son iguales estos dos Vectores?: " +resultado);
    }
}
