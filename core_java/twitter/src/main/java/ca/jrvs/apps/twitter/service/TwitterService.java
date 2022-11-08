package ca.jrvs.apps.twitter.service;

import static java.awt.SystemColor.text;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Entities;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class TwitterService implements Service{
  private CrdDao dao;
  static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
  @Autowired
  public TwitterService (CrdDao dao){this.dao = dao;}

  @Override
  public Tweet postTweet(Tweet tweet) {

    String s=tweet.getText();
    try {
      if (s.length() > 140) {
        logger.error("Exceeded character limit");

        throw new IOException("exceeded charracter limit");


      }
      Coordinates coordinates= tweet.getCoordinates();


      if (coordinates!=null){
        List<Double> coordinatesList=coordinates.getCoordinates();
        if (coordinatesList!=null){
          Double lon= coordinatesList.get(0);
          Double lat= coordinatesList.get(1);

          boolean b = (lon > 180.0)
              || (lon < -90.0 )|| (lat> 90.0) || (lat<-90.0);

          if(b){
            throw new IOException("latitude or longitude out of range");

          }

        }


      }


    }catch (IOException e){
      logger.error("tweet not valid check contraints", e.getMessage());
      return null;


    }
    return (Tweet) dao.create(tweet);
  }

  private Boolean validateId(String id){
    int id_length= id.length();
    if (id==null){
      return false;

    }

    if(id_length==0){
      return false;

    }
    for (int i=0;i<id_length;i++){
      if (id.charAt(i)<'0' || id.charAt(i)>'9'){
        return false;

      }


    }

  return true;
  }

  @Override
  public Tweet showTweet(String id, String[] fields) {
    Boolean result= validateId(id);
    if (result== false){
      throw new IllegalArgumentException("invalid id");

    }
    if (fields!=null && fields.length==0){
      throw new IllegalArgumentException("in");
    }
    Tweet tweet= (Tweet) dao.findById(id);

    List<String> possible_fields = new LinkedList<String>(Arrays.asList("created_at","id",
        "id_str",
        "text",
        "entities",
        "coordinates",
        "retweet_count",
        "favorite_count",
        "favorited",
        "retweeted"));

    if (fields!=null){
      for ( String i:fields){

        if(possible_fields.contains(i)) {
          possible_fields.remove(i);

        }}

      for (String j:possible_fields){
        if (j.equals("created_at")){
          tweet.setCreatedAt(null);

        }
        else if (j.equals("id")){
          tweet.setId(null);
        }
        else if (j.equals("id_str")){
          tweet.setIdStr(null);

        }
        else if (j.equals("text")){
          tweet.setText(null);

        }
        else if(j.equals("entities")){
          tweet.setEntities(null);
        }
        else if (j.equals("coordinates")){
          tweet.setCoordinates(null);
        }


      }

    }
    return tweet;

  }

  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    List<Tweet> tweets= new ArrayList<>();

    for(String id: ids){
      Boolean result = validateId(id);
      if (result== true){

        try {

          Tweet tweet = (Tweet) dao.deleteById(id);
          tweets.add(tweet);
        }  catch(Exception e){

          throw new IllegalArgumentException("tweet id doesnt exist");
        }
      }

    }

    return tweets;
  }


}
