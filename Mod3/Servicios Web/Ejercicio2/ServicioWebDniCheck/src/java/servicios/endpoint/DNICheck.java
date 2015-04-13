/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Dani
 */
@WebService
public class DNICheck {
    
    private String[] arrayLetras = {"T", "R", "W", "A", "G", "M", "Y",
"F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C",
"K", "E", "T"}; 
    
    public DNICheck(){
        super();
    }
    
    @WebMethod
    public boolean esDNIValido(String nif){
        Boolean valido = false;
        String texto;
        Integer numero;
        String[] contenido = nif.split("-");
        numero = Integer.parseInt(contenido[0]);
        texto = contenido[1];
        if(texto.equals(generaLetra(numero))){
            valido = true;
        }
        return valido;
    }
    
    @WebMethod
    public String generaLetra(Integer dni){
        String letra;
        Integer pos = dni%23;
        return letra = arrayLetras[pos];
    }
    
}
