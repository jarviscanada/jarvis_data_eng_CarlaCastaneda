package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {
  @JsonProperty("hashtags")
  private List<Hashtag>hashTag;
  @JsonProperty("user_mentions")
  private List<UserMention> userMention;

  @JsonProperty("hashtags")
  public List<Hashtag> getHashTag() {
    return hashTag;
  }

  @JsonProperty("hashtags")
  public void setHashTag(List<Hashtag> hashTag) {
    this.hashTag = hashTag;
  }

  @JsonProperty("user_mentions")
  public List<UserMention> getUserMention() {
    return userMention;
  }
  @JsonProperty("user_mentions")
  public void setUserMention(List<UserMention> userMention) {
    this.userMention = userMention;
  }
}
