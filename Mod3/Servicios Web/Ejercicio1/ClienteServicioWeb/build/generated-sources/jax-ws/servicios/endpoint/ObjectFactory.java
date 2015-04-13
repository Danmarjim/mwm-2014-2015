
package servicios.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaludaAResponse_QNAME = new QName("http://endpoint.servicios/", "saludaAResponse");
    private final static QName _SaludaA_QNAME = new QName("http://endpoint.servicios/", "saludaA");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaludaAResponse }
     * 
     */
    public SaludaAResponse createSaludaAResponse() {
        return new SaludaAResponse();
    }

    /**
     * Create an instance of {@link SaludaA }
     * 
     */
    public SaludaA createSaludaA() {
        return new SaludaA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludaAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.servicios/", name = "saludaAResponse")
    public JAXBElement<SaludaAResponse> createSaludaAResponse(SaludaAResponse value) {
        return new JAXBElement<SaludaAResponse>(_SaludaAResponse_QNAME, SaludaAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludaA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.servicios/", name = "saludaA")
    public JAXBElement<SaludaA> createSaludaA(SaludaA value) {
        return new JAXBElement<SaludaA>(_SaludaA_QNAME, SaludaA.class, null, value);
    }

}
