package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Component

public class TwitterCLIApp {
  private  static Controller controller;
  public static final String USAGE = "USAGE: TwitterCLIApp post|show|delete [options]";
  @Autowired
  public TwitterCLIApp (Controller controller){this.controller = controller;}

  public static void main(String[] args) {

    TwitterCLIApp app= new TwitterCLIApp(controller);
    app.run(args);


  }
  public void run (String[] args){
    if (args.length==0){
      throw new IllegalArgumentException(USAGE);

    }else if (args[0].equalsIgnoreCase("post")){
      Tweet tweet =controller.postTweet(args);
      printTweet(tweet);
      System.out.println();

    }else if (args[0].equalsIgnoreCase("show")){
      Tweet tweet = controller.showTweet(args);
      printTweet(tweet);
      System.out.println("coordinates"+tweet.getCoordinates());

    }else if (args[0].equalsIgnoreCase("delete")){
      List<Tweet> tweets=  controller.deleteTweet(args);
      tweets.stream().forEach(this::printTweet);

    }else {
      throw new IllegalArgumentException("no correct arguments"+ USAGE);

    }



  }
  private  void printTweet (Tweet tweet){
    String s = null;

    try{
      s = JsonParser.toJson(tweet,true,false);
      System.out.println(s);
    } catch(JsonProcessingException e){
      e.printStackTrace();


    }


  }

}
