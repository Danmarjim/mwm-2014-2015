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
    private static final String USER_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/user_timeline.json";
    private static final String FRIEND_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/home_timeline.json";
    private static final String POST_TWEET_URI = "https://api.twitter.com/1.1/statuses/update.json"; 
    private static final String TRENDS_URI = "https://api.twitter.com/1.1/trends/place.json?id=23424950"; //?id=1;

    private static Integer numeroDeLlamadas = 0;
    
    private Client client;

    public TwitterClient() {
        try {
            client = TwitterAuthorization.createClient();
        } catch (Exception ex) {
            Logger.getLogger(TwitterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Response getUserTimeline() {
        System.out.println("Numero de llamadas: "+ ++numeroDeLlamadas);
        final Response response = client.target(USER_TIMELINE_URI).request().get();
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

   
    public Response getFriendsTimeline() {
        System.out.println("Numero de llamadas: "+ ++numeroDeLlamadas);
        final Response response = client.target(FRIEND_TIMELINE_URI).request().get();
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
    
    public Response updateStatus(String status){
        System.out.println("Numero de llamadas: "+ ++numeroDeLlamadas);
        MultivaluedMap<String, String> parametros = new MultivaluedHashMap<String, String>();
        parametros.add("status", status);
        final Response response = client.target(POST_TWEET_URI).request().post(Entity.form(parametros));
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
    
    public Response getTrends(){
        //España WOID = 23424950
        System.out.println("Numero de llamadas: "+ ++numeroDeLlamadas);
        final Response response = client.target(TRENDS_URI).request().get();
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
}
