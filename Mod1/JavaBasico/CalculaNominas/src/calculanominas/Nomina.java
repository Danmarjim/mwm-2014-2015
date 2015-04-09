package calculanominas;

/**
 * Clase para calcular la nomina de cada Empleado
 */

public class Nomina {
    
    public static void main(String[] args) {
        Nomina nomina = new Nomina();
        Empleado emp;
        emp = new Empleado("Juan Fernandez", 10.5);
        
        nomina.calculaNomina(emp, 65);
        nomina.calculaNomina(emp, 50);
        nomina.resumen(emp);
        
        nomina.calculaNomina(emp, 70);
        nomina.resumen(emp);
        
    }
    
    /**
     * Metodo que calcula la nomina para un empleado dado y el numero de horas realizadas en la semana
     * @param emp indica el Empleado
     * @param horas indica el numero de horas trabajadas en una semana
     */
    
    public void calculaNomina(Empleado emp, int horas){
        String nombre = emp.getNombre();
        System.out.println("Calculando la nomina para " + nombre);
        int horasExtra = horas - 40;
        double pagaSemanal = 40 * 10.5;
        double pagaExtra = 10.5 * 1.5;
        pagaSemanal += (double)horasExtra * pagaExtra;
        
        //Crear datos para el metodo resumen
        int semanasTotal = emp.getSemanasTrabajadasTotal() + 1;
        emp.setSemanasTrabajadasTotal(semanasTotal);
        
        int horasTrabajadas = emp.getHorasTrabajadasTotal() + horas;
        emp.setHorasTrabajadasTotal(horasTrabajadas);
        
        double sueldoTotal = emp.getSueldoTotal() + pagaSemanal;
        emp.setSueldoTotal(sueldoTotal);
        
        //Comprobar horas extra no sobrepasan 30
        int horasSemanaPasada = emp.getHotasExtraSemanaPasada();
        int horasTotales = horasSemanaPasada + horasExtra;
        if(horasTotales >= 30)
            System.out.println("\t Aviso -> " + nombre + " ha hecho " + horasTotales + " horas extras en las ultimas dos semanas");
        emp.setHorasExtraSemanaPasada(horasExtra);        
        
        System.out.println("\t Nomina Semanal: " + pagaSemanal + "€");
    } 
    
    /**
     * Metodo para mostrar en pantalla el resumen de actividad de un Empleado, horas trabajas, semanas trabajadas y sueldo acumulado
     * @param emp indica el Empleado.
     */
    
    private void resumen(Empleado emp){
        
        System.out.println("Resumen de datos para el trabajador " + emp.getNombre());
        System.out.println("\t " + emp.getHorasTrabajadasTotal() + " horas trabajadas desde el comienzo");
        System.out.println("\t " + emp.getSemanasTrabajadasTotal() + " semanas trabajadas desde el comienzo ");
        System.out.println("\t Sueldo acumulado desde el comienzo " + emp.getSueldoTotal() + "€");
            
    }
    
}
