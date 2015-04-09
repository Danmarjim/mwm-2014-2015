/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgeoipservice;

import javax.xml.ws.WebServiceRef;
import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;

/**
 *
 * @author Dani
 */
public class Main {

    @WebServiceRef(wsdlLocation = "http://www.webservicex.net/geoipservice.asmx?wsdl")
    private static GeoIPService service;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ip = "150.214.142.14";
        //String ip = "192.168.0.156";
        System.out.println("Localizacion para la ip: "+ip+":"+getLocation(ip));
    }
    
    public static String getLocation(String ip){
        GeoIP result = service.getGeoIPServiceSoap().getGeoIP(ip);
        GeoIP context = service.getGeoIPServiceSoap12().getGeoIPContext();
        
        System.out.println("Contexto: IP "+context.getIP()+ " Country code: "+context.getCountryCode()+" Name: "+context.getCountryName()+" Code details "+context.getReturnCodeDetails());
    
        return "Pais: "+result.getCountryName()+" Codigo de pais: "+result.getCountryCode()+" Detalles: "+result.getReturnCodeDetails();
        
    }
    
}
