package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterDao implements CrdDao<Tweet,String> {
  //URI Constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/1.1/statuses/update.json";
  private static final String SHOW_PATH = "/1.1/statuses/show.json";
  private static final String DELETE_PATH="/1.1/statuses/destroy";
  //URI SYMBOLS
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";
  //Response code
  private static final int HTTP_OK = 200;

  private HttpHelper httpHelper;

  @Autowired
  public TwitterDao(HttpHelper httpHelper){
    this.httpHelper=httpHelper;
  }

  @Override
  public Tweet create(Tweet entity) {
    try {
      httpHelper.httpPost(new URI(API_BASE_URI + POST_PATH ));
    }catch (Exception e){
      e.printStackTrace();

    }

    return null;
  }

  @Override
  public Tweet findById(String s) {

    try {
      httpHelper.httpGet(new URI(API_BASE_URI + SHOW_PATH));




    }catch (Exception e){
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Tweet deleteById(String s) {
    return null;
  }
}
