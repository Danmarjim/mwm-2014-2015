
package es.us.mwm.twitter.entities.trends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Trend {

    private String as_of;
    private String created_at;
    private List<Location> locations = new ArrayList<Location>();
    private List<Trend_> trends = new ArrayList<Trend_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The as_of
     */
    public String getAs_of() {
        return as_of;
    }

    /**
     * 
     * @param as_of
     *     The as_of
     */
    public void setAs_of(String as_of) {
        this.as_of = as_of;
    }

    /**
     * 
     * @return
     *     The created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * 
     * @param created_at
     *     The created_at
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * 
     * @return
     *     The locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The trends
     */
    public List<Trend_> getTrends() {
        return trends;
    }

    /**
     * 
     * @param trends
     *     The trends
     */
    public void setTrends(List<Trend_> trends) {
        this.trends = trends;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
