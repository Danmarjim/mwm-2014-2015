package cabinapeaje;

import java.util.Scanner;

/**
 * Clase para calcular la recaudacion y numero de vehiculos que pasan por una cabina de peaje
 */

public class PruebaCabinaPeaje {
   
    public static void main(String[] args){
        CabinaPeaje cabina = new CabinaPeaje();
        Scanner tcld = new Scanner(System.in);
        int ejes, peso;
        
        System.out.println("Introduzca los datos del camion 1");
        System.out.print("\t Numero de ejes: ");
        ejes = Integer.parseInt(tcld.nextLine());
        System.out.print("\t Peso Total: ");
        peso = Integer.parseInt(tcld.nextLine());
        
        Vehiculo camion1 = new Vehiculo("camion", ejes, peso);
        
        Vehiculo coche = new Vehiculo("coche");
        
        System.out.println("Introduzca los datos del camion 2");
        System.out.print("\t Numero de ejes: ");
        ejes = tcld.nextInt();
        System.out.print("\t Peso Total: ");
        peso = tcld.nextInt();
        
        Vehiculo camion2 = new Vehiculo("camion", ejes, peso);
        
        cabina.calculaPeaje(camion1);
        cabina.muestraDatos();
        cabina.calculaPeaje(coche);
        cabina.recaudar();
        cabina.calculaPeaje(camion2);
        cabina.muestraDatos();
    }
   
}
