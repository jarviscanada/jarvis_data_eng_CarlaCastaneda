package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import java.util.Arrays;
import java.util.List;

public class TwitterController implements Controller{
  private static final String COORD_SEP = ":";
  private static final String COMMA = ",";
  private static final String BRACKET="[]";

  private Service service;

  public TwitterController (Service service){this.service= service;}


  @Override
  public Tweet postTweet(String[] args) {
    Tweet tweet;
    Tweet newTweet;
    if (args.length != 3) {
      throw new IllegalArgumentException(
          "USAGE TwitterApp post\"tweet_text\"\"latitude:longitude\"");

    } else {
      tweet = new Tweet();
      tweet.setText(args[1]);
      Coordinates coordinates = new Coordinates();
      String[] coords2 = args[2].split(COORD_SEP);

      coordinates.setCoordinates(
          Arrays.asList(Double.valueOf(coords2[0]), Double.valueOf(coords2[1])));
      newTweet = service.postTweet(tweet);
    }
    return newTweet;
  }

  @Override
  public Tweet showTweet(String[] args) {
    Tweet tweet = null;
    if (args.length == 3) {
      String[] arrayOptions = args[2].split(COMMA);
      tweet=service.showTweet(args[1], arrayOptions);

    } else if (args.length == 2) {

      tweet = service.showTweet(args[1], null);
    } else {
      new IllegalArgumentException(
          "USAGE: TwitterApp show tweet_id | (OPTIONAL) [fields1,fields2] ");
    }
    return tweet;
  }

  @Override
  public List<Tweet> deleteTweet(String[] args) {
    List<Tweet> tweets = null;
    if (args.length!=2){
      new IllegalArgumentException("USAGE: TwitterApp delete [id1,id2]");


    } else  {
      String[] ids=args[1].split(COMMA);
      ids[0]= ids[0].replaceAll("\\[|\\]","");
      ids[ids.length-1]= ids[ids.length-1].replaceAll("\\[|\\]","");

      tweets=service.deleteTweets(ids);

    }
    return tweets;
  }
}
