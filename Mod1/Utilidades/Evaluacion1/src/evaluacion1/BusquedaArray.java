package evaluacion1;

import java.lang.reflect.Array;

import java.util.Arrays;

public class BusquedaArray {

    private int[] array;

    public static void main(String[] args){        
        
        MiArray arrayPrueba = new MiArray(10);
        BusquedaArray ba = new BusquedaArray();
        
        //Obtener cuanto tarda la llamada al metodo, caso timeMillis
        long t1 = System.currentTimeMillis();
        arrayPrueba.busquedaSecuencial();
        long t2 = System.currentTimeMillis();
        long resultado = t2-t1;
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +resultado);
        
        long t3 = System.currentTimeMillis();
        arrayPrueba.busquedaBinaria();
        long t4 = System.currentTimeMillis();
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +(t4-t3));
        
        //Obtener cuanto tarda la llamada al metodo, caso nanoTime
        long t5 = System.nanoTime();
        arrayPrueba.busquedaSecuencial();
        long t6 = System.nanoTime();
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +(t6-t5));
        
        long t7 = System.nanoTime();
        arrayPrueba.busquedaBinaria();
        long t8 = System.nanoTime();
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +(t8-t7));
        
        //Ordenacion y metodo Sort
        long t9 = System.currentTimeMillis();
        arrayPrueba.ordenacionSort();
        long t10 = System.currentTimeMillis();
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +(t10-t9));
        
        long t11 = System.currentTimeMillis();
        ordenacionSecuencial(arrayPrueba);
        long t12 = System.currentTimeMillis();
        System.out.println("Tiempo que ha tardado en realizar la llamada: " +(t12-t11));
        
        
    }   
    
    public static boolean ordenacionSecuencial(MiArray ar){
        boolean encontrado = false;
        int numArray = ar.getNumArray();
        int limite = numArray;
        int numero = numArray + 1;
        for(int i=0, n=limite; i!=n; i++){
            if(numero == i){
                encontrado = true;
            }
        }
        return encontrado;
    }
}