package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Hashtag {
  private String text;
  private List<Integer> indices=null;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<Integer> getIndices() {
    return indices;
  }

  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }
}
