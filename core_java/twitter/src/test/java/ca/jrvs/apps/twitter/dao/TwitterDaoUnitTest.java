package ca.jrvs.apps.twitter.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterDaoUnitTest {
  @Mock
  HttpHelper mockHelper;

  @InjectMocks
  TwitterDao dao;

  @Test
  public void showTweet(){
    String hashTag= "#abd";
    String text = "@celebrity"+hashTag+" "+ System.currentTimeMillis();
    Double lat=1d;
    Double lon=-1d;

    when(mockHelper.httpPost(isNotNull()));
  }

  @Test
  void create() {
  }

  @Test
  void findById() {
  }

  @Test
  void deleteById() {
  }
}