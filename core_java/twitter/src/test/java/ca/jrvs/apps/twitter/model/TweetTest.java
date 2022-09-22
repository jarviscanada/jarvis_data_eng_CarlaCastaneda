package ca.jrvs.apps.twitter.model;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.example.JsonParser;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TweetTest {
  Tweet tweet;

  @Before
  public void setUp() throws Exception {
    tweet = new Tweet();
    tweet.setText("fsdfs");
    Coordinates coordinates = new Coordinates();
    coordinates.setType("point");
    List<Double> coords =Arrays.asList(2.0,2.0);
    coordinates.setCoordinates(coords);
    tweet.setCoordinates(coordinates);


  }
  @Test
  public void test(){
    try {
      String s =JsonParser.toJson(tweet, true, true);
      System.out.println(s);
      Tweet tweetS= JsonParser.toObjectFromJSON(s,Tweet.class);
      System.out.print("coords "+ tweetS.getCoordinates());
      System.out.print("id "+ tweetS.getIdStr());

    }catch (Exception e) {
      e.printStackTrace();
    }


  }
}