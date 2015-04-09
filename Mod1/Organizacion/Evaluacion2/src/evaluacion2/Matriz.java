package evaluacion2;

import java.util.Random;

public class Matriz {

    private int[][] matriz;
    private int nFilas, nColum, n;
    
    /**
     * Constructor con dos parametros de entrada
     * @param nFilas define el numero de filas de la matriz
     * @param nColum define el numero de columnas de la matriz
     */
    
    public Matriz(int nFilas, int nColum){
        this.nFilas = nFilas;
        this.nColum = nColum;
        
        matriz = new int[nFilas][nColum];
        Random e = new Random();
        int n;
        for(int i = 0; i!=nFilas; i++){
            for(int j = 0; j!=nColum; j++){
                n = e.nextInt(10);
                matriz[i][j] = n;
                //System.out.println("Matriz[" +i + "][" +j + "]: " +matriz[i][j]);
            }
            //System.out.println("");
        }
    } 
    
    /**
     * Constructor con un parametro de entrada
     * @param n Define tanto las filas como las columnas de la matriz
     */
    
    public Matriz(int n){
        this.n = n;    
        
        matriz = new int[n][n];
        Random e = new Random();
        int in;
        for(int i = 0; i!=n; i++){
            for(int j = 0; j!=n; j++){
                in = e.nextInt(10);
                matriz[i][j] = in;
                //System.out.println("Matriz[" +i + "][" +j + "]: " +matriz[i][j]);
            }
            //System.out.println("");
        }
    }
    
    /**
     * Metodo toString para modificar lo que muestra por pantalla
     * @return muestra Matriz recorrida por Filas
     */
    
    public String toStringFilas(){
        String resultado = "";
        
        for(int i = 0, mFilas = matriz.length; i!=mFilas; i++){
            for(int j = 0, mColum = matriz[0].length; j!=mColum; j++){
                resultado += "Matriz[" +i + "][" +j + "]:";
                resultado += matriz[i][j] + "\n";
            }
        }        
        return resultado;
    }
    
    /**
     * Metodo toString para modificar lo que muestra por pantalla
     * @return muestra Matriz recorrida por Columnas
     */
    
    public String toStringCol(){
        String resultado = "";
        
        for(int j = 0, mColum = matriz[0].length; j!=mColum; j++){
            for(int i = 0, mFilas = matriz.length; i!=mFilas; i++){
                resultado += "Matriz[" +i + "][" +j + "]:";
                resultado += matriz[i][j] + "\n"; 
            }
        }
        return resultado;
    }
    
    /**
     * Metodo para modificar el orden de Matriz(n,a)
     * @return devuelve el int[][] transpuesta
     */
    
    public int[][] transpuesta(){
        int indiceA = matriz.length, indiceB = matriz[0].length;
        int[][] base = new int[indiceB][indiceA]; 
        for (int i=0; i < indiceA; i++) 
            for (int j=0; j < indiceB; j++) {
                base[j][i] = matriz[i][j];
            }
        return base;
    }
    
    /**
     * Metodo para calcular la matriz transpuesta de una matriz dada por parametros
     * @param m Una Matriz m
     * @return devuelve la matriz transpuesta de la matriz dada por parametros.
     */
    
    public Matriz transpuesta(Matriz m){      
        int indiceA = m.getMatriz().length, indiceB = m.getMatriz()[0].length;
        Matriz matrizResultado = new Matriz(indiceB, indiceA);       
        
        for (int i=0, n = m.getMatriz().length; i!=n; i++) {
            for (int j=0, w = m.getMatriz()[0].length; j!=w ; j++) {
                matrizResultado.getMatriz()[j][i] = m.getMatriz()[i][j];
            }
        }        
        return matrizResultado;
    }
    
    /**
     * Metodo privado de la clase para devolver tipo Matriz
     * @return devuelve el tipo Matriz
     */
    
    private int[][] getMatriz(){
        return matriz;
    }
   
}
