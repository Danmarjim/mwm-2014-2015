package ejercicio5;

import java.util.Random;

public class Ejercicio5 {
    
    public static void main(String[] args){
        
        //Forma cutre y larga de hacerlo
        
        //Creacion del Array con una determinada longitud
        int[] arrayEntero = new int[10];
        
        //Relleamos el Array con los datos que queremos
        arrayEntero[0] = 1;
        arrayEntero[1] = 2;
        arrayEntero[2] = 3;
        arrayEntero[3] = 4;
        arrayEntero[4] = 5;
        arrayEntero[5] = 6;
        arrayEntero[6] = 7;
        arrayEntero[7] = 8;
        arrayEntero[8] = 9;
        arrayEntero[9] = 10;

        System.out.println();
        System.out.println("//////Mostrar en su orden normal/////");    
        System.out.println();
        
        //Forma de hacerla mas mejor entodavia
        int[] arrayBucle = new int[10];
        for(int i = 0, n=arrayBucle.length; i!=n; i++){
            arrayBucle[i] = i;
            System.out.println("Mostrar el dato de la posicion " + i + " del Array: " + arrayBucle[i]);
        }
        
        System.out.println();
        System.out.println("/////Mostrar en orden inverso/////");
        System.out.println();
        
        //Mostrar en orden inverso
        int[] arrayBucle2 = new int[10];
        for(int i = arrayBucle2.length-1; i != -1; i--){
            arrayBucle2[i] = i;
            System.out.println("Mostrar el dato de la posicion " + i + " del Array: " + arrayBucle2[i]);
        }
        
        //Crear Matriz[3][4] y rellenar con datos aleatorios
        int[][] matriz = new int[3][4];
        Random e = new Random();
        int base = 10, n;
        for(int i = 0, dato = 3; i!=dato; i++){
            for(int j = 0, dato2 = 4; j!=dato2; j++){
                n = base + e.nextInt(90);
                matriz[i][j]= n;
                System.out.println("Matriz[" +i + "][" +j + "]: " +matriz[i][j]);
               
            }
        }
        
        //Recorrido por filas
        System.out.println("Matriz recorrida por filas");
        int[][] matrizFila = new int[3][4];
        Random e2 = new Random();
        int base2 = 10, n2;
        for(int i = 0, mFila = matrizFila.length; i!=mFila;i++){
            for(int j = 0, mColum = matrizFila[0].length; j!=mColum; j++){
                n2 = base2 + e2.nextInt(90);
                matriz[i][j]= n2;
                System.out.println("Matriz[" +i + "][" +j + "]: " +matriz[i][j]);
            }
            System.out.println("");
        }
        
        //Recorrido por columnas
        System.out.println("Matriz recorrida por columnas");
        int[][] matrizColum = new int[3][4];
        Random e3 = new Random();
        int base3 = 10, n3;
        for(int j = 0, mColum2 = matrizColum[0].length; j!=mColum2;j++){
            for(int i = 0, mFila2 = matrizColum.length; i!=mFila2; i++){
                n3 = base3 + e3.nextInt(90);
                matriz[i][j]= n3;                
                System.out.println("Matriz[" +i + "][" +j + "]: " +matriz[i][j]);
            }
            System.out.println("");
        }
            
    }            
}
            