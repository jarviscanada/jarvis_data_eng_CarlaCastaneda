package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {

  @Mock
  TwitterService service;

  @InjectMocks
  TwitterController controller;


  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void postTweet (){
    when (service.postTweet(any())).thenReturn(new Tweet());

    String[] args= new String[] {"post","tweet_txt","20:20"};
    controller.postTweet(args);






  }
  @Test
  public void showTweet(){
    when(service.showTweet(anyString(),any())).thenReturn(new Tweet());

    String[] args= new String[]{"show","1234312321321"};
    controller.showTweet(args);
  }

  @Test
  public void deleteTweet(){
    when (service.deleteTweets(any())).thenReturn(new ArrayList<>());
    String[] args= new String[] {"delete","[123214343,214242342432]"};
    controller.deleteTweet(args);

  }

}