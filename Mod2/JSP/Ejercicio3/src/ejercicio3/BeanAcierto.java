package ejercicio3;

import java.util.Random;

public class BeanAcierto {
    
    private int respuesta;
    private boolean exito;
    private int numIntentos;
    private String pista;
    
    public BeanAcierto() {
        inicia();
    }
    
    public void setIntento(String numero){
        numIntentos++;
        
        int g;
        try {
            g = Integer.parseInt(numero);
        } catch (NumberFormatException e){
            g = -1;
        }        
        
        if(respuesta == g){
            exito = true;
        } else if(g == -1){
            pista = "La proxima vez un numero";
        } else if(g < respuesta){
            pista = "mayor";
        } else if(g > respuesta){
            pista = "menor";
        }
    }
    
    public String getPista(){
        String res = "";
        res += pista;
        return res;
    }
    
    public boolean getExito(){
        return exito;
    }
    
    public int getNumIntentos(){
        return numIntentos;
    }
    
    public void inicia(){
        Random rand = new Random();
        respuesta = rand.nextInt(((100 - 1) + 1) + 1);
        exito = false;
        numIntentos = 0;
    }
}
