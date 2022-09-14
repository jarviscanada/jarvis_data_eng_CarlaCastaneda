package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterService implements Service{
  private CrdDao dao;
  static final Logger logger = LoggerFactory.getLogger(TwitterService.class);
  public TwitterService (CrdDao dao){this.dao = dao;}

  @Override
  public Tweet postTweet(Tweet tweet) {

    String s=tweet.getText();
    try {
      if (s.length() > 140) {
        logger.error("Esceeded character limit");

        throw new IOException("exceeded charracter limit");


      }
      List<Double> coordinates= tweet.getCoordinates().getCoordinates();
      if (coordinates!=null){
        Double lon= coordinates.get(0);
        Double lat= coordinates.get(1);

        boolean b = (lon > 180.0)
            || (lon < -90.0 )|| (lat> 90.0) || (lat<-90.0);

        if(b){
          throw new IOException("latitude or longitude out of range");

        }

      }


    }catch (IOException e){
      logger.error("tweet not valid check contraints", e.getMessage());
      return null;


    }
    return (Tweet) dao.create(tweet);
  }

  @Override
  public Tweet showTweet(String id, String[] fields) {
    return null;
  }

  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    return null;
  }

  public static void main(String[] args) {
    String consumerKey= System.getenv("consumerKey");
    String consumerSecret= System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret= System.getenv("tokenSecret");

    HttpHelper hp= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);

    CrdDao crdDao= new TwitterDao(hp);
    TwitterService ts= new TwitterService(crdDao);
    Tweet tweet= new Tweet();
    tweet.setText("fsfndsfsfnsdjfnkjsnfkjsnjkjkdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        + "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"
        + "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
    ts.postTweet(tweet);
  }
}
