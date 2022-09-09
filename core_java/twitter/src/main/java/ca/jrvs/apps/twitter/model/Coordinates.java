package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)

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
