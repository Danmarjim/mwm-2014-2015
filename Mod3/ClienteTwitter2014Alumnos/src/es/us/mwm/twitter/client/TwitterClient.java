package es.us.mwm.twitter.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author afernandez
 */
public class TwitterClient {

    //TODO: 2. Incluir la URI del servicio REST
    private static final String FRIENDS_TIMELINE_URI = "";

    private Client client;

    public TwitterClient() {
        try {
            client = TwitterAuthorization.createClient();
        } catch (Exception ex) {
            Logger.getLogger(TwitterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    public Response getFriendsTimeline() {
        //System.out.println("Numero de llamadas: "+ ++numeroDeLlamadas);
        final Response response = null;
        //final Response response = client.target(FRIEND_TIMELINE_URI).request().get();
        //TODO: 3. Llamada al servicio
        if (response.getStatus() != 200) {
            String errorEntity = null;
            if (response.hasEntity()) {
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("La petición a twitter no tuvo éxito. Código de respuesta: "
                    + response.getStatus() + ", razón: " + response.getStatusInfo().getReasonPhrase()
                    + ", entity: " + errorEntity);
        }
        return response;
    }
    
    //TODO: 4. Incluir métodos para llamar a otros servicios: UserTimeline, Update, Trends, etc.
}