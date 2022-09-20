package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {
  static Tweet tweet;
  static Tweet newTweet;
  @Mock
  CrdDao dao;

  @InjectMocks
  TwitterService service;

  @BeforeClass
  public static void setup(){
    tweet = new Tweet();
    tweet.setText("test");
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(Arrays.asList(50.0,0.0));
    tweet.setCoordinates(coordinates);


  }

  @Test
  public void postTweet() {


    when (dao.create(any())).thenReturn(new Tweet());
    service.postTweet(tweet);
  }

  @Test
  public void showTweet() {


    when (dao.findById(anyString())).thenReturn(new Tweet());
    String[] fields= new String[]{"created_at"};
    service.showTweet("2", fields);
  }

  @Test
  public void deleteTweets() {


    when (dao.deleteById(anyString())).thenReturn(new Tweet());
    String[] fields= new String[]{"created_at"};
    String [] ids = new String[]{"1232434242","123132432534535"};
    service.deleteTweets(ids);
  }
}