package ca.jrvs.apps.twitter.model;

import java.util.List;

public class Coordinates {
  private String type;
  private List<Integer> coordinates;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<Integer> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(List<Integer> coordinates) {
    this.coordinates = coordinates;
  }
}
