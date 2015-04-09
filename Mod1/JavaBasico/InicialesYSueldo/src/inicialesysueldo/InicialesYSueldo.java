package inicialesysueldo;

import java.util.Scanner;

public class InicialesYSueldo {
    public static void main(String[] args) {
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre = tcld.nextLine();
        System.out.print("Introduzca su apellido: ");
        String apellido = tcld.nextLine();
       
        String s = nombre.substring(0, 1).toUpperCase();
        String s1 = apellido.substring(0, 1).toUpperCase();
       
        System.out.print("Introduzca su sueldo anual: ");
        Double sueldo = tcld.nextDouble();
        Double sueldoMensual = sueldo/12;
        
        System.out.println("Las iniciales son " + s + s1);
        System.out.println("El sueldo mensual es " + sueldoMensual);
    }
}
