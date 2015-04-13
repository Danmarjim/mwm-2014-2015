package es.us.mwm.twitter.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Feature;

import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1AuthorizationFlow;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;

//import org.glassfish.jersey.jackson.JacksonFeature;

public class TwitterAuthorization {

    private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTIES_FILE_NAME = "twitterclient.properties";
    private static final String PROPERTY_CONSUMER_KEY = "consumerKey";
    private static final String PROPERTY_CONSUMER_SECRET = "consumerSecret";
    private static final String PROPERTY_TOKEN = "token";
    private static final String PROPERTY_TOKEN_SECRET = "tokenSecret";

    /**
     * Main method that creates a {@link Client client} and initializes the
     * OAuth support with configuration needed to connect to the Twitter and
     * retrieve statuses.
     * <p/>
     * Execute this method to demo
     *
     * @param args Command line arguments.
     * @throws Exception Thrown when error occurs.
     */
    public static Client createClient() throws Exception {
        // retrieve consumer key/secret and token/secret from the property file
        // or system properties
        loadSettings();

        final ConsumerCredentials consumerCredentials = new ConsumerCredentials(
                PROPERTIES.getProperty(PROPERTY_CONSUMER_KEY),
                PROPERTIES.getProperty(PROPERTY_CONSUMER_SECRET));

        Feature filterFeature;
        if (PROPERTIES.getProperty(PROPERTY_TOKEN) == null) {

            // we do not have Access Token yet. Let's perfom the Authorization Flow first,
            // let the user approve our app and get Access Token.
            final OAuth1AuthorizationFlow authFlow = OAuth1ClientSupport.builder(consumerCredentials)
                    .authorizationFlow(
                            "https://api.twitter.com/oauth/request_token",
                            "https://api.twitter.com/oauth/access_token",
                            "https://api.twitter.com/oauth/authorize")
                    .build();
            final String authorizationUri = authFlow.start();

            System.out.println("Introduce esta URI en un navegador web y autorizame:");
            System.out.println(authorizationUri);
            System.out.print("Introduce el código de autorización: ");
            String verifier = null;
            try {
                verifier = IN.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            final AccessToken accessToken = authFlow.finish(verifier);

            // store access token for next application execution
            PROPERTIES.setProperty(PROPERTY_TOKEN, accessToken.getToken());
            PROPERTIES.setProperty(PROPERTY_TOKEN_SECRET, accessToken.getAccessTokenSecret());

            // get the feature that will configure the client with consumer credentials and
            // received access token
            filterFeature = authFlow.getOAuth1Feature();
        } else {
            AccessToken storedToken = new AccessToken(PROPERTIES.getProperty(PROPERTY_TOKEN),
                    PROPERTIES.getProperty(PROPERTY_TOKEN_SECRET));
            // build a new feature from the stored consumer credentials and access token
            filterFeature = OAuth1ClientSupport.builder(consumerCredentials).feature()
                    .accessToken(storedToken).build();
        }

        // create a new Jersey client and register filter feature that will add OAuth signatures and
        // JacksonFeature that will process returned JSON data.
        Client client = ClientBuilder.newBuilder()
                .register(filterFeature)
                //.register(JacksonFeature.class)
                .build();
        // persist the current consumer key/secret and token/secret for future use
        storeSettings();

        return client;
    }

    private static void loadSettings() {
        FileInputStream st = null;
        try {
            st = new FileInputStream(PROPERTIES_FILE_NAME);
            PROPERTIES.load(st);
        } catch (IOException e) {
            // ignore
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }

        for (String name : new String[]{PROPERTY_CONSUMER_KEY, PROPERTY_CONSUMER_SECRET,
            PROPERTY_TOKEN, PROPERTY_TOKEN_SECRET}) {
            String value = System.getProperty(name);
            if (value != null) {
                PROPERTIES.setProperty(name, value);
            }
        }

        if (PROPERTIES.getProperty(PROPERTY_CONSUMER_KEY) == null
                || PROPERTIES.getProperty(PROPERTY_CONSUMER_SECRET) == null) {
            System.out.println("No se han encontrado valores para consumerKey y/o consumerSecret en el fichero de propiedades twitterclient.properties"
                    + "Tienes que incluir estos valores en el fichero de propiedades que se encuentra en la raíz de tu proyecto.");
            System.exit(1);
        }
    }

    private static void storeSettings() {
        FileOutputStream st = null;
        try {
            st = new FileOutputStream(PROPERTIES_FILE_NAME);
            PROPERTIES.store(st, null);
        } catch (IOException e) {
            // ignore
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (IOException ex) {
                // ignore
            }
        }
    }
}
