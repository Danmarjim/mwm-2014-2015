package cabinapeaje;

/** 
 * Clase para definiri el tipo Vehiculo
 */

public class Vehiculo {
    
    private String tipo;
    private int ejes, pesoTotal;
    
    /**
     * Construcor de la clase Vehiculo, se utiliza cuando el tipo sea Coche
     * @param coche indica que es un Coche
     */
    
    public Vehiculo(String coche) {
        tipo = coche;
    }
    
    /**
     * Constructor de la clase Vehiculo, se utiliza cuando el tipo es Camion
     * @param camion indica que es un Camion
     * @param nejes indica el numero de ejes
     * @param peso indica el peso
     */
    
    public Vehiculo(String camion, int nejes, int peso) {
        tipo = camion;
        ejes = nejes;
        pesoTotal = peso;
    }
    
    /**
     * Metodo para obtener el tipo de Vehiculo
     * @return devuelve el tipo de vehiculo
     */
    
    public String getTipo(){
        return tipo;
    }
    
    /**
     * Metodo para obtener el numero de ejes
     * @return devuelve el numero de ejes
     */
    
    public int getEjes(){
        return ejes;
    }
    
    /**
     * Metodo para obtener el peso del vehiculo
     * @return devuelve el peso del vehiculo
     */
    
    public int pesoTotal(){
        return pesoTotal;
    }
}
