package ca.jrvs.apps.twitter.dao;

import static ca.jrvs.apps.twitter.example.JsonParser.toJson;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gdata.util.common.base.PercentEscaper;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import ca.jrvs.apps.twitter.example.JsonParser;

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

  private URI getPostUri(Tweet entity) throws URISyntaxException, JsonProcessingException {
    StringBuilder request= (new StringBuilder(API_BASE_URI+ POST_PATH+ QUERY_SYM));
    int params=0;
    PercentEscaper pe= new PercentEscaper(" :{}\"",false);



    if (entity.getText()!=null){
      if (params!=0){
        request.append(AMPERSAND);
      }
      request.append("status"+EQUAL+ pe.escape(entity.getText()));
      params=1;

    }
    if (entity.getId()!=0){
      if (params!=0){
        request.append(AMPERSAND);
      }
      request.append("id"+EQUAL+entity.getId());
      params=1;

    }
    if (entity.getIdStr()!=null){
      if (params!=0){
        request.append(AMPERSAND);

      }
      request.append("id_str"+EQUAL+entity.getIdStr());
      params=1;
    }

    if (entity.getText()!=null){
      if (params!=0){
        request.append(AMPERSAND);

      }

      request.append("status"+EQUAL+ pe.escape(entity.getText()));
      params=1;

    }
    if (entity.getCreatedAt()!=null){
      if (params!=0){
        request.append(AMPERSAND);

      }
      request.append("created_at"+EQUAL+entity.getCreatedAt());
      params=1;
    }
    if (entity.getEntities()!=null){
      if (params!=0){
        request.append(AMPERSAND);

      }
      request.append("entities"+EQUAL+pe.escape(toJson(entity.getEntities(),true,false)));
      params=1;
    }
    if (entity.getCoordinates()!=null){
      if (params!=0){
        request.append(AMPERSAND);

      }
      request.append("coordinates"+EQUAL+pe.escape(toJson(entity.getCoordinates(),true,false)));
      params=1;


    }
    if (params!=0){
      request.append(AMPERSAND);
    }
    request.append("favorite_count"+EQUAL+entity.getFavoriteCount()+AMPERSAND);
    request.append("retweet_count"+EQUAL+entity.getRetweetCount()+AMPERSAND);
    request.append("favorited"+EQUAL+entity.isFavorited()+AMPERSAND);
    request.append("retweeted"+EQUAL+entity.isRetweeted());



    URI uri= new URI(String.valueOf(request));
    return uri;

  }

  @Override
  public Tweet create(Tweet entity)  {
    URI uri = null;
    try{
     uri= getPostUri(entity);

    } catch(URISyntaxException  | JsonProcessingException e){
      e.printStackTrace();

    }
    HttpResponse response=httpHelper.httpPost(uri);


    return null;
  }
  private Tweet responseToTweet(Integer Expectedcode,HttpResponse response){
    Tweet tweet= null;
    return tweet;


  }

  @Override
  public Tweet findById(String s) {

    try {

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
