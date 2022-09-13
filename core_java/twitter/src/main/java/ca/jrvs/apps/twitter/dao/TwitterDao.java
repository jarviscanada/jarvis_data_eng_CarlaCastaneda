package ca.jrvs.apps.twitter.dao;

import static ca.jrvs.apps.twitter.example.JsonParser.toJson;
import static ca.jrvs.apps.twitter.example.JsonParser.toObjectFromJSON;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gdata.util.common.base.PercentEscaper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TwitterDao implements CrdDao<Tweet, String> {

  //URI Constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/1.1/statuses/update.json";
  private static final String SHOW_PATH = "/1.1/statuses/show.json";
  private static final String DELETE_PATH = "/1.1/statuses/destroy";
  //URI SYMBOLS
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";
  //Response code
  private static final int HTTP_OK = 200;

  private final HttpHelper httpHelper;

  @Autowired
  public TwitterDao(HttpHelper httpHelper) {
    this.httpHelper = httpHelper;
  }

  private URI getPostUri(Tweet entity) throws URISyntaxException, JsonProcessingException {
    StringBuilder request = (new StringBuilder());
    request.append(API_BASE_URI).append(POST_PATH).append(QUERY_SYM);

    URI uri = new URI(getParameters(entity, request));
    return uri;

  }


  @Override
  public Tweet create(Tweet entity) {
    URI uri = null;
    try {
      uri = getPostUri(entity);

    } catch (URISyntaxException | JsonProcessingException e) {
      e.printStackTrace();

    }
    HttpResponse response = this.httpHelper.httpPost(uri);

    return responseToTweet(HTTP_OK, response);
  }

  private Tweet responseToTweet(Integer expectedCode, HttpResponse response) {
    Tweet tweet = null;

    int status = response.getStatusLine().getStatusCode();
    if (status != expectedCode) {
      try {
        System.out.println(EntityUtils.toString(response.getEntity()));
      } catch (IOException e) {
        e.printStackTrace();

      }
      throw new RuntimeException("HTTP response has unexpected status code:" + status);

    }
    if (response.getEntity() == null) {

      throw new RuntimeException("http response bosy is empty");

    }

    String json;
    try {
//      json = toJson(response, true, false);
      json = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("unable to convert entity to string ", e);
    }

    try {
      tweet = toObjectFromJSON(json, Tweet.class);

    } catch (IOException e) {
      throw new RuntimeException("Unable to convert JSON str to Object", e);


    }
    return tweet;


  }

  private String getParameters(Tweet entity, StringBuilder request) throws JsonProcessingException {
//    StringBuilder request= (new StringBuilder());

    int params = 0;

    PercentEscaper pe = new PercentEscaper("", false);

    if (entity.getText() != null) {
      if (params != 0) {
        request.append(AMPERSAND);
      }
      request.append("status" + EQUAL + pe.escape(entity.getText()));
      params = 1;

    }
    if ((entity.getId()) != null) {
      if (params != 0) {
        request.append(AMPERSAND);
      }
      request.append("id" + EQUAL + entity.getId());
      params = 1;

    }
    if (entity.getIdStr() != null) {
      if (params != 0) {
        request.append(AMPERSAND);

      }
      request.append("id_str" + EQUAL + entity.getIdStr());
      params = 1;
    }

    if (entity.getCreatedAt() != null) {
      if (params != 0) {
        request.append(AMPERSAND);

      }
      request.append("created_at" + EQUAL + entity.getCreatedAt());
      params = 1;
    }
    if (entity.getEntities() != null) {
      if (params != 0) {
        request.append(AMPERSAND);

      }
      request.append("entities" + EQUAL + pe.escape(toJson(entity.getEntities(), true, false)));
      params = 1;
    }
    if (entity.getCoordinates() != null) {
      if (params != 0) {
        request.append(AMPERSAND);

      }
      request.append(
          "coordinates" + EQUAL + pe.escape(toJson(entity.getCoordinates(), true, false)));
      params = 1;


    }
    if (params != 0) {
      request.append(AMPERSAND);
    }
    request.append("favorite_count" + EQUAL + entity.getFavoriteCount() + AMPERSAND);
    request.append("retweet_count" + EQUAL + entity.getRetweetCount() + AMPERSAND);
    request.append("favorited" + EQUAL + entity.isFavorited() + AMPERSAND);
    request.append("retweeted" + EQUAL + entity.isRetweeted());
    String r = request.toString();
    return r;


  }


  @Override
  public Tweet findById(String s) {
    HttpResponse response;

    try {
      StringBuilder request = (new StringBuilder());
      request.append(API_BASE_URI + SHOW_PATH + QUERY_SYM + "id" + EQUAL + s);

      URI uri = new URI(request.toString());

      response = this.httpHelper.httpGet(uri);
      return responseToTweet(HTTP_OK, response);


    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public Tweet deleteById(String s) {
    HttpResponse response = null;

    try {
      StringBuilder request = (new StringBuilder());
      request.append(API_BASE_URI + DELETE_PATH + "/" + s + ".json");

      URI uri = new URI(request.toString());

      response = this.httpHelper.httpPost(uri);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return responseToTweet(HTTP_OK, response);
  }

//  public static void main(String[] args) throws JsonProcessingException {
//    String consumerKey = System.getenv("consumerKey");
//    String consumerSecret = System.getenv("consumerSecret");
//    String accessToken = System.getenv("accessToken");
//    String tokenSecret = System.getenv("tokenSecret");
//    HttpHelper httpHelper= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);
//
//    CrdDao<Tweet,String> twitterDao= new TwitterDao(httpHelper);
//    Tweet t=twitterDao.findById("1567593424232103936");
//    System.out.println(toJson(t,true,false));
//  }
}
