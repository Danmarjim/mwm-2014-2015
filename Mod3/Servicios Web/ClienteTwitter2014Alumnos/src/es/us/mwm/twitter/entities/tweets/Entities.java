
package es.us.mwm.twitter.entities.tweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Entities {

    private List<Object> urls = new ArrayList<Object>();
    private List<Object> hashtags = new ArrayList<Object>();
    private List<Object> user_mentions = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The urls
     */
    public List<Object> getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    /**
     * 
     * @return
     *     The hashtags
     */
    public List<Object> getHashtags() {
        return hashtags;
    }

    /**
     * 
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * 
     * @return
     *     The user_mentions
     */
    public List<Object> getUser_mentions() {
        return user_mentions;
    }

    /**
     * 
     * @param user_mentions
     *     The user_mentions
     */
    public void setUser_mentions(List<Object> user_mentions) {
        this.user_mentions = user_mentions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
