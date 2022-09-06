package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Entities {
  private List<Hashtag>hashTag;
  private List<UserMention> userMention;

  public List<Hashtag> getHashTag() {
    return hashTag;
  }

  public void setHashTag(List<Hashtag> hashTag) {
    this.hashTag = hashTag;
  }

  public List<UserMention> getUserMention() {
    return userMention;
  }

  public void setUserMention(List<UserMention> userMention) {
    this.userMention = userMention;
  }
}
