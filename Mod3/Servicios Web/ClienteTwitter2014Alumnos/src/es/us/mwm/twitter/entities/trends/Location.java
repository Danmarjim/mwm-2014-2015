
package es.us.mwm.twitter.entities.trends;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Location {

    private String name;
    private Long woeid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The woeid
     */
    public Long getWoeid() {
        return woeid;
    }

    /**
     * 
     * @param woeid
     *     The woeid
     */
    public void setWoeid(Long woeid) {
        this.woeid = woeid;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
