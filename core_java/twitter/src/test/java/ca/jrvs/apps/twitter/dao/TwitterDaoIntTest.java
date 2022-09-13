package ca.jrvs.apps.twitter.dao;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Entities;
import static ca.jrvs.apps.twitter.example.JsonParser.toJson;

import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minidev.json.JSONUtil;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;

public class TwitterDaoIntTest {

  private TwitterDao dao;
  static String consumerKey;
  String consumerSecret;
  String accessToken;
  String tokenSecret;

  @Before
  public void setUp()  {
    consumerKey= System.getenv("consumerKey");
    consumerSecret= System.getenv("consumerSecret");
    accessToken= System.getenv("accessToken");
    tokenSecret= System.getenv("tokenSecret");

    HttpHelper httpHelper= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);

    this.dao=new TwitterDao(httpHelper);
  }

  @Test
  public void create() throws Exception {



    Tweet tweet= new Tweet();
    String hashtag="#abc";
    tweet.setText("Hi I am in France!"+hashtag+" ");
    List<Double> coordinates= Arrays.asList(1d,-1d);
    Coordinates c= new Coordinates();
    c.setCoordinates(coordinates);
    tweet.setCoordinates(c);
    System.out.println( toJson(tweet,true,true));
    Tweet newTweet= this.dao.create(tweet);



    assertTrue(hashtag.contains(newTweet.getEntities().getHashTag().get(0).getText()));



//    this.dao.create(tweet);


  }
//  @Test
//  public void deleteById(){
//
//    Tweet newTweet = this.dao.deleteById("1569733116775759872");
//    assertTrue(newTweet.getText().equals("Hi I am in Spain!#abc"));
//  }
//  @Test
//  public void findById(){
//    Tweet newTweet= this.dao.findById("1569739850512830466");
//    assertTrue(newTweet.getText().equals("Hi I am in dubai!#abc"));
//  }
}