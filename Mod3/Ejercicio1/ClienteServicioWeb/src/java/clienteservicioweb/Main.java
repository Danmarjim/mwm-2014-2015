/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservicioweb;

import javax.xml.ws.WebServiceRef;
import servicios.endpoint.Bienvenida;
import servicios.endpoint.BienvenidaService;

/**
 *
 * @author Dani
 */
public class Main {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/ServicioWebBienvenida/BienvenidaService?wsdl")
    private static BienvenidaService service;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Llamando al servicio");
        System.out.println("Dani");
        System.out.println("Fin");
    }
    
    private static String saluda(String arg){
        Bienvenida port = service.getBienvenidaPort();
        return port.saludaA(arg);
    }
    
}
