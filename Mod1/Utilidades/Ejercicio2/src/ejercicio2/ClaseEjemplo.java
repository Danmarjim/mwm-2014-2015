package ejercicio2;

import java.util.Arrays;
import java.util.Random;

public class ClaseEjemplo {

    public static void main(String[] args){
        
        /*Random r = new Random();
        int[] array = new int[10];
        int j = 0;
        for(int i = 0, n = array.length; i!=n; i++){
            j = r.nextInt(21);
            if (j % 2 == 0) {
                array[i] = j;
            }                 
        }*/
        
        Random r = new Random();
        int[] array = new int[10];
        for(int i = 0, n = array.length; i!=n; i++){
            array[i] = r.nextInt(11)*2;
        }       
        
        //mostrarEnPantalla(array, "Hola que hace");
        
        //mostrarEnPantalla(array, "Vector antes de ordenar");
        Arrays.sort(array);
        mostrarEnPantalla(array, "Vector ordenado");
        
        int j = Arrays.binarySearch(array, 11);
        System.out.println("El 11 deberia de estar en la posicion " + Math.abs(j-1));
        
        
        int pos = Arrays.binarySearch(array, 12);
        if(pos>=0){
            System.out.println("El 12 esta en la posicion " +pos);
        } else {
            System.out.println("El 12 deberia de estar en la posicion " +Math.abs(pos-1));
        }
    }
    
    private static void mostrarEnPantalla(int[] array, String texto){        
        System.out.println(texto);
        for(int i=0, n = array.length; i!=n; i++){
            System.out.println(array[i]);
        }    
    }
    
    
                
}
    
    
