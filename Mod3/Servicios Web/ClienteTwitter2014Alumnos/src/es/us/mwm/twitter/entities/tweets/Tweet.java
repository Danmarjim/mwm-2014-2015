
package es.us.mwm.twitter.entities.tweets;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Tweet {

    private Object coordinates;
    private Boolean truncated;
    private String created_at;
    private Boolean favorited;
    private String id_str;
    private Object in_reply_to_user_id_str;
    private Entities entities;
    private String text;
    private Object contributors;
    private Long id;
    private Long retweet_count;
    private Object in_reply_to_status_id_str;
    private Object geo;
    private Boolean retweeted;
    private Object in_reply_to_user_id;
    private Object place;
    private String source;
    private User user;
    private Object in_reply_to_screen_name;
    private Object in_reply_to_status_id;
    private Boolean possibly_sensitive;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The coordinates
     */
    public Object getCoordinates() {
        return coordinates;
    }

    /**
     * 
     * @param coordinates
     *     The coordinates
     */
    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * 
     * @return
     *     The truncated
     */
    public Boolean getTruncated() {
        return truncated;
    }

    /**
     * 
     * @param truncated
     *     The truncated
     */
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
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
     *     The favorited
     */
    public Boolean getFavorited() {
        return favorited;
    }

    /**
     * 
     * @param favorited
     *     The favorited
     */
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    /**
     * 
     * @return
     *     The id_str
     */
    public String getId_str() {
        return id_str;
    }

    /**
     * 
     * @param id_str
     *     The id_str
     */
    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    /**
     * 
     * @return
     *     The in_reply_to_user_id_str
     */
    public Object getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    /**
     * 
     * @param in_reply_to_user_id_str
     *     The in_reply_to_user_id_str
     */
    public void setIn_reply_to_user_id_str(Object in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    /**
     * 
     * @return
     *     The entities
     */
    public Entities getEntities() {
        return entities;
    }

    /**
     * 
     * @param entities
     *     The entities
     */
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The contributors
     */
    public Object getContributors() {
        return contributors;
    }

    /**
     * 
     * @param contributors
     *     The contributors
     */
    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The retweet_count
     */
    public Long getRetweet_count() {
        return retweet_count;
    }

    /**
     * 
     * @param retweet_count
     *     The retweet_count
     */
    public void setRetweet_count(Long retweet_count) {
        this.retweet_count = retweet_count;
    }

    /**
     * 
     * @return
     *     The in_reply_to_status_id_str
     */
    public Object getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    /**
     * 
     * @param in_reply_to_status_id_str
     *     The in_reply_to_status_id_str
     */
    public void setIn_reply_to_status_id_str(Object in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    /**
     * 
     * @return
     *     The geo
     */
    public Object getGeo() {
        return geo;
    }

    /**
     * 
     * @param geo
     *     The geo
     */
    public void setGeo(Object geo) {
        this.geo = geo;
    }

    /**
     * 
     * @return
     *     The retweeted
     */
    public Boolean getRetweeted() {
        return retweeted;
    }

    /**
     * 
     * @param retweeted
     *     The retweeted
     */
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    /**
     * 
     * @return
     *     The in_reply_to_user_id
     */
    public Object getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    /**
     * 
     * @param in_reply_to_user_id
     *     The in_reply_to_user_id
     */
    public void setIn_reply_to_user_id(Object in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    /**
     * 
     * @return
     *     The place
     */
    public Object getPlace() {
        return place;
    }

    /**
     * 
     * @param place
     *     The place
     */
    public void setPlace(Object place) {
        this.place = place;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The in_reply_to_screen_name
     */
    public Object getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    /**
     * 
     * @param in_reply_to_screen_name
     *     The in_reply_to_screen_name
     */
    public void setIn_reply_to_screen_name(Object in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    /**
     * 
     * @return
     *     The in_reply_to_status_id
     */
    public Object getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    /**
     * 
     * @param in_reply_to_status_id
     *     The in_reply_to_status_id
     */
    public void setIn_reply_to_status_id(Object in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    /**
     * 
     * @return
     *     The possibly_sensitive
     */
    public Boolean getPossibly_sensitive() {
        return possibly_sensitive;
    }

    /**
     * 
     * @param possibly_sensitive
     *     The possibly_sensitive
     */
    public void setPossibly_sensitive(Boolean possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
