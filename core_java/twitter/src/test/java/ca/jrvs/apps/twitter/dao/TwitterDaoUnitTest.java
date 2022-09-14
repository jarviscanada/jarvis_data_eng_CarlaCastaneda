package ca.jrvs.apps.twitter.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterDaoUnitTest {
  @Mock
  HttpHelper mockHelper;

  @InjectMocks
  TwitterDao dao;

  @Test
  public void showTweet() throws Exception {
    String hashTag= "#abd";
    String text = "@celebrity"+hashTag+" "+ System.currentTimeMillis();
    Double lat=1d;
    Double lon=-1d;
    Tweet tweet= new Tweet();
    tweet.setText(text);
    Coordinates co = new Coordinates();
    co.setCoordinates(Arrays.asList(lat,lon));
    tweet.setCoordinates(co);

    when(mockHelper.httpPost(isNotNull())).thenThrow(new RuntimeException("mock"));
    try{
      dao.create(tweet);
      fail();
    }catch(RuntimeException e){
      assertTrue(true);
    }

    //TEST happy path
    //however, we don't want to call parseResponseBody
    //we will make a spyDAO which can fake parseresponsebody return value;

    String tweetJsonStr = "{\n"
        + "\"created_at\":\"Mon Feb 18 21:24:39 +0000 2019\",\n"
        + "\"id\":1097607853932564480,\n"
        + "\"id_str\":\"1097607853932564480\",\n"
        + "\"text\":\"test with loc223\",\n"
        + "\"entities\":{\n"
        + "   \"hashtags\":[],"
        + "   \"user_mentions\":[]"
        + "},\n"
        + "\"coordinates\":null,"
        + "\"retweet_count\":0,\n"
        + "\"favorite_count\":0,\n"
        + "\"favorites\":false,\n"
        + "\"retweeted\":false\n"
        + "}";
    when(mockHelper.httpPost(isNotNull())).thenReturn(null);
    TwitterDao spyDao= Mockito.spy(dao);
    Tweet expectedTweet = JsonParser.toObjectFromJSON(tweetJsonStr,Tweet.class);

    doReturn(expectedTweet).when(spyDao).responseToTweet(anyInt(),any());

    Tweet newTweet= spyDao.create(tweet);
    assertNotNull(newTweet);
    assertNotNull(newTweet.getText());

    // delete by id
    String s= "123455445544";
    Tweet deletedTweet= spyDao.deleteById(s);
    assertNotNull(deletedTweet);
    assertNotNull(deletedTweet.getId());

    //find by id
//    assertNull(foundTweet);
    Tweet findTweet = spyDao.findById(anyString());
    assertNotNull(findTweet);


  }
  @Test
  public void findById(){
    TwitterDao spyDao= Mockito.spy(dao);

    doReturn(null).when(spyDao).responseToTweet(anyInt(),any());
    Tweet findTweet = spyDao.findById(anyString());
    assertNull(findTweet);


  }


}