package ca.jrvs.apps.twitter.dao;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Entities;
import static ca.jrvs.apps.twitter.example.JsonParser.toJson;

import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONUtil;
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
    tweet.setText("Hi I am in Spain!"+hashtag+" ");
    System.out.println( toJson(tweet,true,true));
    Tweet newTweet= this.dao.create(tweet);
    
//    assertTrue(hashtag.contains(newTweet.getEntities().getHashTag().get(0).getText()));



//    this.dao.create(tweet);


  }
}