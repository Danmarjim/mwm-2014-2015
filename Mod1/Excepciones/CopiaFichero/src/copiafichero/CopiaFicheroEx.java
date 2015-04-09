package copiafichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaFicheroEx {

    public static void main(String[] args){
        int numBytes = 0;
        byte[] buffer = new byte[512];
        String nombreFichEnt = null;
        String nombreFichSal = null;
        FileInputStream fichEnt;
        FileOutputStream fichSal;
        
        try {
            nombreFichEnt = args[0];
            nombreFichSal = args[1];
            fichEnt = new FileInputStream(nombreFichEnt);
            fichSal = new FileOutputStream(nombreFichSal);
            int bytesLeidos;
            while((bytesLeidos = fichEnt.read(buffer)) != -1){
                fichSal.write(buffer, 0, bytesLeidos);
                numBytes += bytesLeidos; 
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Sintaxis: java CopiaFichEx [archivo_extrada] [archivo_salida]");         
        } catch (FileNotFoundException e) {
            System.out.println("No se puede abrir el fichero " +nombreFichEnt);
        } catch (IOException e) {
            System.out.println("Se produjo una excepcion de E/S");
        } finally {
            if(numBytes > 0)
                System.out.println(numBytes+ " bytes escritos");
        }
    }
    
}
