package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterControllerIntTest {
   static Controller controller;

  @BeforeClass
  public static void setup(){
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret   = System.getenv("tokenSecret");

    HttpHelper hp= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);
    CrdDao crd = new TwitterDao(hp);
    Service service = new TwitterService(crd);

    controller= new TwitterController(service);


  }

  @Test
  public void postTweet() {
    String [] args = new String[] {"post","ROSAyaliyaliyaliyalibhjbhjbj","1:-1"};
    Tweet tweet=controller.postTweet(args);
    try {
      String json = JsonParser.toJson(tweet, true, true);
      System.out.println("json string"+json);
    }catch (JsonProcessingException e){
      e.printStackTrace();

    }

  }

  @Test
  public void showTweet() {
    String [] args = new String[] {"show","1572237490320203776"};
    Tweet tweet =controller.showTweet(args);

    try {
      String json = JsonParser.toJson(tweet, true, true);
      System.out.println("json string"+json);
    }catch (JsonProcessingException e){
      e.printStackTrace();

    }

  }

//  @Test
//  public void deleteTweet() {
//    String [] args = new String[] {"delete","[1572631486599430144,1572625979096567809]"};
//
//    controller.deleteTweet(args);
//  }
}