
package servicios.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Bienvenida", targetNamespace = "http://endpoint.servicios/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Bienvenida {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saludaA", targetNamespace = "http://endpoint.servicios/", className = "servicios.endpoint.SaludaA")
    @ResponseWrapper(localName = "saludaAResponse", targetNamespace = "http://endpoint.servicios/", className = "servicios.endpoint.SaludaAResponse")
    @Action(input = "http://endpoint.servicios/Bienvenida/saludaARequest", output = "http://endpoint.servicios/Bienvenida/saludaAResponse")
    public String saludaA(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
