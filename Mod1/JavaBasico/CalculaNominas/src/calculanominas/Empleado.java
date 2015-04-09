package calculanominas;

/**
 * Clase para definir el tipo Empleado
 */

public class Empleado {
    
    private String nombre;
    private double pagaHora;
    private int horasExtreSemanaPasada = 0;
    private double sueldoTotal = 0;
    private int horasTotal = 0;
    private int semanasTotal = 0;
    
    /**
     * Constructor de la clase
     * @param nombre inidica el nombre del empleado
     * @param pagaHora indica el valor de la hora en euros
     */
    
    public Empleado(String nombre, double pagaHora){
        this.nombre = nombre;
        this.pagaHora = pagaHora;
    }
    
    /**
     * Metodo para obtener el nombre del empleado
     * @return devuelve el nombre
     */
    
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Metodo para obtener el valor de la hora en euros
     * @return devuelve el valor de la hora en euros
     */
    
    public double getPagaHora(){
        return pagaHora;
    }
    
    /**
     * Metodo para obtener en numero de horas extras de la semana pasada
     * @return devuelve el numero de horas
     */
    
    public int getHotasExtraSemanaPasada(){
        return horasExtreSemanaPasada;
    }
    
    /**
     * Metodo para actualizar el numero de horas extras realizadas
     * @param horasExtra variable que indica el numero de horas extras realizadas 
     */
    
    public void setHorasExtraSemanaPasada(int horasExtra){
        horasExtreSemanaPasada = horasExtra;
    }
    
    /**
     * 
     * @param nomina
     * @param horas
     */
    
    public void nuevaPaga(double nomina, int horas){
        sueldoTotal = nomina;
        horasTotal = horas;
    }
    
    /**
     * Metodo para obtener el sueldo total
     * @return devuelve el sueldo total en euros
     */
    
    public double getSueldoTotal(){
        return sueldoTotal;
    }
    
    /**
     * Metodo para actualizar el sueldo total
     * @param sueldoTotal se actualiza a un nuevo valor
     */
    
    public void setSueldoTotal(double sueldoTotal){
        this.sueldoTotal = sueldoTotal;
    }
    
    /**
     * Metodo para obtener el numero total de horas trabajadas
     * @return devuelve el numero de horas trabajadas totales
     */
    
    public int getHorasTrabajadasTotal(){
        return horasTotal;
    }
    
    /**
     * Metodo para actualizar el numero total de horas trabajadas
     * @param horasTotal actualiza el numero de horas trabajadas
     */
    
    public void setHorasTrabajadasTotal(int horasTotal){
        this.horasTotal = horasTotal;
    }
    
    /**
     * Metodo para obtener el numero de semanas trabajadas
     * @return  devuelve el numero de semanas trabajadas
     */
    
    public int getSemanasTrabajadasTotal(){
        return semanasTotal;
    }
    
    /**
     * Metodo para actualizar el numero de semanas trabajadas
     * @param semanasTotal actualiza el numero de semanas trabajadas 
     */
    
    public void setSemanasTrabajadasTotal(int semanasTotal){
        this.semanasTotal = semanasTotal;
    }
    
}
