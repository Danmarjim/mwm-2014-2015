/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.endpoint;

import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Dani
 */
@Path("holamundo/{username}")
public class HolaMundo {

    @Context
    private UriInfo context;
    private static Map<String, Integer> visitasUsuario = new HashMap<String, Integer>();

    /**
     * Creates a new instance of HolaMundo
     */
    public HolaMundo() {
    }

    /**
     * Retrieves representation of an instance of servicios.endpoint.HolaMundo
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@PathParam("username") String username) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "<html lang=\"en\"><body><h1>Hola "+username+"!!</h1>Esta es tu visita numero: "+contarVisitas(username)+"</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of HolaMundo
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
    
    private String contarVisitas(String username){
        String numVisitas = "1";
        if(visitasUsuario.containsKey(username)){
            logger.info("Usuario: " + username + " encontrado.");
            Integer visitas = visitasUsuario.get(username);
            visitasUsuario.put(username, visitas + 1);
            numVisitas = String.valueOf(visitas);
        } else {
            System.out.println();
            visitasUsuario.put(username, 2);
        }
        logger.info("Map: " + visitasUsuario.toString());
        return numVisitas;
    }
}
