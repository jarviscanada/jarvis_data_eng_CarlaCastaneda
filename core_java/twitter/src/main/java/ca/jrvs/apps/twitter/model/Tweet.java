package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created_at",
    "id",
    "id_str",
    "text",
    "entities",
    "coordinates",
    "retweet_count",
    "favorite_count",
    "favorited",
    "retweeted"
})
public class Tweet {
  @JsonProperty("text")
  private String text;
  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("id_str")
  private String idStr;
  @JsonProperty("id")
  private int id;
  @JsonProperty("coordinates")
  private Coordinates coordinates;
  @JsonProperty("entities")
  private Entities entities;
  @JsonProperty("retweet_count")
  private int retweetCount=0;
  @JsonProperty("favorite_count")
  private int favoriteCount=0;
  @JsonProperty("favorited")
  private boolean favorited=false;
  @JsonProperty("retweeted")
  private boolean retweeted=false;
  @JsonProperty("id")
  public int getId() {
    return id;
  }

  @JsonProperty("coordinates")
  public Coordinates getCoordinates() {
    return coordinates;
  }
  @JsonProperty("coordinates")
  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }
  @JsonProperty("entities")
  public Entities getEntities() {
    return entities;
  }
  @JsonProperty("entities")

  public void setEntities(Entities entities) {
    this.entities = entities;
  }
  @JsonProperty("retweet_count")
  public int getRetweetCount() {
    return retweetCount;
  }
  @JsonProperty("retweet_count")

  public void setRetweetCount(int retweetCount) {
    this.retweetCount = retweetCount;
  }
  @JsonProperty("favorite_count")
  public int getFavoriteCount() {
    return favoriteCount;
  }
  @JsonProperty("favorite_count")
  public void setFavoriteCount(int favoriteCount) {
    this.favoriteCount = favoriteCount;
  }
  @JsonProperty("favorited")
  public boolean isFavorited() {
    return favorited;
  }
  @JsonProperty("favorited")
  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }
  @JsonProperty("retweeted")
  public boolean isRetweeted() {
    return retweeted;
  }
  @JsonProperty("retweeted")
  public void setRetweeted(boolean retweeted) {
    this.retweeted = retweeted;
  }
  @JsonProperty("id")
  public void setId(int id) {
    this.id = id;
  }
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }
  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }
  @JsonProperty("created_at")
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
  @JsonProperty("id_str")
  public String getIdStr() {
    return idStr;
  }
  @JsonProperty("id_str")
  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

 
}
