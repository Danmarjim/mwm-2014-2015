package cabinapeaje;

/**
 * Clase para definir el tipo CabinaPeaje
 */

public class CabinaPeaje {
    
    private double totalDesdeRecogida;
    private int vehiculosDesdeRecogida;
    
    /**
     * Construcor sin parametros
     */
    
    public CabinaPeaje() {
    }
    
    /**
     * Metodo que muestra por pantalla la recaudacion y el numero del vehiculo que pasa por el peaje
     */
    
    public void muestraDatos(){
        System.out.println("Total desde la ultima recogida - Peaje: " + totalDesdeRecogida + " Vehiculos: " + vehiculosDesdeRecogida);
    }
    
    /**
     * Metodo que muestra por pantalla la recaudacion hasta ese momento
     */
    
    public void recaudar() {
        System.out.println(" *** Procediendo a la recaudacion *** ");
        muestraDatos();
        totalDesdeRecogida = 0.0 ;
        vehiculosDesdeRecogida = 0;
    }
    
    /**
     * Metodo para calcular el peaje del Vehiculo
     * @param vehiculo con este parametro se indica que tipo de Vehiculo es
     */
    
    public void calculaPeaje(Vehiculo vehiculo){
        String tipo = vehiculo.getTipo();
        if(tipo.equals("coche")){
            double peaje = 6.5;
            totalDesdeRecogida += peaje;
            vehiculosDesdeRecogida++;
            System.out.println("Coche - Peaje: " + peaje);
        } else {
            double peaje;
            int ejes = vehiculo.getEjes();
            int pesoTotal = vehiculo.pesoTotal();
            double numeroToneladas = ((double)pesoTotal)/1000;
            peaje = ejes * 5.0 + numeroToneladas * 10;
            totalDesdeRecogida += peaje;
            vehiculosDesdeRecogida++;
            System.out.println("Camion - Ejes: " + ejes + " Peso Total: " + pesoTotal + " Peaje: " + peaje);
        }
    }
}
