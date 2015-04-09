
package evaluacion2;

public class MainMatriz {
        
    public static void main(String[] args){
        
        
        //Creacion de distintas matrices
        Matriz prueba = new Matriz(3,4);        
        Matriz prueba2 = new Matriz(3); 
        
        //Creamos la matriz transpuesta de PRUEBA
        Matriz prueba3 = prueba.transpuesta(prueba);
                       
        System.out.println("Mostramos por pantalla la matriz prueba tanto por filas como por columnas"); 
        System.out.println("");
        System.out.println(prueba.toStringFilas());
        System.out.println(prueba.toStringCol()); 
                       
        System.out.println("Mostramos por pantalla la matriz prueba2 tanto por filas como por columnas");   
        System.out.println("");
        System.out.println(prueba2.toStringFilas());
        System.out.println(prueba2.toStringCol());
        
        System.out.println("Mostramos por pantalla la matriz transpuesta de prueba");   
        System.out.println("");
        System.out.println(prueba3.toStringCol());
        
    }
}
