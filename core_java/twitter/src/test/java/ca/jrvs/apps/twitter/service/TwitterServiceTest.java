package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TwitterServiceTest {
//
//  static TwitterService ts;
//
//  @BeforeClass
//  public static void setUp(){
//    String consumerKey= System.getenv("consumerKey");
//    String consumerSecret= System.getenv("consumerSecret");
//    String accessToken = System.getenv("accessToken");
//    String tokenSecret= System.getenv("tokenSecret");
//
//    HttpHelper hp= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);
//
//    CrdDao crdDao= new TwitterDao(hp);
//    ts= new TwitterService(crdDao);
//
//  }
//  @Test
//  public void testPostTweet() {
//
//    Tweet tweet= new Tweet();
////    tweet.setText("fsfndsfsfnsdjfnkjsnfkjsnjkjkdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
////        + "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
////        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
////        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
////        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
////    ts.postTweet(tweet);
//    tweet.setText("my name is john");
//    Tweet hi=ts.postTweet(tweet);
//    System.out.println(hi.getIdStr());
//
//  }
//
//  @Test
//  public void testShowTweet() {
//    String id="1571871453062090759";
//    String [] fields = {"created_at"};
//
//    ts.showTweet(id,fields);
//
//
//  }
//  @Rule
//  public ExpectedException exceptionRule = ExpectedException.none();
//  @Test (expected = IllegalArgumentException.class)
//  public void testDeleteTweetsException() {
//    //exceptionRule.expext(IllegalArgumentException.class
//
////    exceptionRule.expectMessage("tweet id doesnt exist");
//
//    ts.deleteTweets( new String[] {"2"});
//
//  }
//
//  @Test
//  public void testDeleteTweets(){
//    ts.deleteTweets( new String[] {"1554530689961414658"});
//
//
//  }
}
