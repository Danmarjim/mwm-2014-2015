package excepcionesnombre;

import java.util.Scanner;

public class ExcepcionesNombre {
    public static void main(String[] args){
        String nombre;
        try {
            nombre = leer();
            System.out.println("El nombre introducido es: " +nombre);
        } catch (Exception e) {
            System.out.println("Error de longitud: " +e.getMessage());
            main(args);
        } 
    }
    
    //Lee lo que le metemos por teclado
    public static String leer() throws ExcepcionNombreCorto, ExcepcionNombreLargo{
        String nombre = null;
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduzca un nombre: ");
        nombre = tcld.nextLine();
        if(nombre.length() > 14){
            throw new ExcepcionNombreLargo();
        } else if (nombre.length() < 8){
            throw new ExcepcionNombreCorto();
        }
        
        return nombre;
    }
}
