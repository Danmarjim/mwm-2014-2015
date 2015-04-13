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
public class Bienvenida {
    
    private String mensajeBienvenida = "Bienvenido";
    
    public Bienvenida(){
        super();
    }
    
    @WebMethod
    public String saludaA(String nombre){
        return mensajeBienvenida += " "+nombre+" ";
    }
}
