package evaluacion1;

import java.util.Arrays;
import java.util.Random;

public class MiArray {

    private int[] resultado;
    private int numArray;
    
    public MiArray(int numArray) {
        
        this.numArray = numArray;
        boolean comprobar = false;
        
        Random r = new Random();
        int k = numArray;
        int[] v = new int[numArray];
        resultado = new int[numArray];
        
        //Rellena el array V del 0 a numArray ordenados.
        for(int i=0; i<numArray; i++){
            v[i]=i;
        }
        
        //MOdificar para que no exista ningun valor igual
        for(int i=0; i<numArray; i++){
            int res = r.nextInt(k);            
            resultado[i] = v[res];
            v[res] = v[k-1];
            k--;                    
        }
        
        //Mostrar el resultado por pantalla
        System.out.println("Este es el Array de longitud " +numArray+ ":");
        for(int i=0; i<numArray; i++){
            System.out.println(resultado[i]);
        }
    }
    
    public int getNumArray(){
        return numArray;
    }
    
    public boolean busquedaSecuencial(){        
        boolean encontrado = false;
        int longitud = getNumArray();
        for(int i=0; i!=longitud; i++){
            if(resultado[i] == numArray+1){
                encontrado = true;
            }
        }        
        return encontrado;
    }
    
    public boolean busquedaBinaria(){
        boolean encontrado = false;
        int j = Arrays.binarySearch(resultado, numArray+1);
        if(j>=0){
            encontrado = true;
        }
        return encontrado;
    }
    
    public void ordenacionSort(){
        Arrays.sort(resultado);
    }
    
}