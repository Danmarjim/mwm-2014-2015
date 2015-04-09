/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteglobalweather;

import javax.xml.ws.WebServiceRef;
import net.webservicex.GlobalWeather;

/**
 *
 * @author Dani
 */
public class Main {

    @WebServiceRef(wsdlLocation = "http://www.webservicex.com/globalweather.asmx?wsdl")
    private static GlobalWeather service;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Cliente del servicio de prevision");
        String pais = "Spain";
        System.out.println("Ciudades de "+pais);
        System.out.println(getCities(pais));
        System.out.println("El tiempo para Sevilla");
        System.out.println(getForecast("Sevilla", "Spain"));
        System.out.println("El tiempo para New York");
        System.out.println(getForecast("New York", "United States"));
    }
    
    public static String getForecast(String city, String country){
        String w = service.getGlobalWeatherSoap().getWeather(city, country);
        return w;
    }
    
    public static String getCities(String country){
        return service.getGlobalWeatherSoap().getCitiesByCountry(country);
    }
    
}
