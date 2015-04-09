package comparanumeros;

import java.util.Scanner;

public class ComparaNumeros {
    public static void main(String[] args){
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int primero = tcld.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int segundo = tcld.nextInt();
        
        if (primero > segundo){
            System.out.println(primero + " es mayor que " + segundo);
        } else if(segundo > primero){
            System.out.println(segundo + " es mayor que " + primero);
        } else {
            System.out.println("Los dos numeros son iguales");
        }
    }
}
