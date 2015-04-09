package evaluacion;

import java.util.Scanner;

public class Monta�aRusa {
    
    private static final int MIN_EDAD_VALIDA = 0;
    private static final int EDAD_MINIMA = 5;
    private static final int EDAD_MAXIMA = 65;
    
    public static void main(String[] args){
        int edad;
        Scanner tcld = new Scanner(System.in);
        
        for(int i = 0;i < 4;i++){
            System.out.print("Introduce tu edad: ");
            edad = tcld.nextInt();
            try {
                montarMonta�aRusa(edad);
                System.out.println("!WOW� Esto es espectacular!");
            } catch (ExcepcionDemasiadoJoven e){
                System.out.println(e.getMessage());
                System.out.println((EDAD_MINIMA - edad) +" a�os mas y podras probarlo");
            } catch (ExcepcionDemasiadoViejo e){
                System.out.println(e.getMessage());
                System.out.println((edad - EDAD_MAXIMA) +" a�os atras esto era un juego de ni�os");                    
            } catch (ExcepcionEdadIlegal e){
                System.out.println(e.getMessage());    
            } finally {
                System.out.println();
            }
        }
    } 
    
    public static void montarMonta�aRusa(int edad) throws ExcepcionDemasiadoJoven, ExcepcionDemasiadoViejo, ExcepcionEdadIlegal {
        
        System.out.println("Intentado montar en la monta�a rusa a la edad de " +edad);
        if(EDAD_MINIMA < edad && edad < EDAD_MAXIMA){
            System.out.println("Montando en la monta�a la rusa...");
        }
        
        if(MIN_EDAD_VALIDA > edad){  
            throw new ExcepcionEdadIlegal();
        } else if(EDAD_MINIMA > edad){
            throw new ExcepcionDemasiadoJoven();
        } else if(EDAD_MAXIMA < edad){
            throw new ExcepcionDemasiadoViejo();
        }        
    }
}

