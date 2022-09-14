package ca.jrvs.apps.twitter.dao.helper;

import static org.junit.Assert.*;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;


public class TwitterHttpHelperTest {
  String consumerKey;
  String consumerSecret;
  String accessToken;
  String tokenSecret;
  HttpHelper httpHelper;
  private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelperTest.class);

  @Before
  public void setUp() throws Exception {
    consumerKey=System.getenv("consumerKey");
    consumerSecret=System.getenv("consumerSecret");
    accessToken= System.getenv("accessToken");
    tokenSecret=System.getenv("tokenSecret");
    httpHelper= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);


  }

  @Test
  public void httpPost() throws URISyntaxException, IOException {
    String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int len= alphabet.length();
    StringBuilder sb= new StringBuilder();
    Random r= new Random();
    for (int i=0;i<50;i++){
      sb.append(alphabet.charAt(r.nextInt(len)));

    }
    HttpResponse response =httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status="+sb));
    System.out.println(EntityUtils.toString(response.getEntity()));

    assertEquals(200,response.getStatusLine().getStatusCode());
        try{
      EntityUtils.consume(response.getEntity());}
    catch (IOException e){
//      e.printStackTrace();
      logger.error("could not close connection");
    }

  }

  @Test
  public void httpGet() throws URISyntaxException, IOException {
    HttpResponse response = httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=CarlaCa01239209"));
    System.out.println(EntityUtils.toString(response.getEntity()));

    assertEquals(200,response.getStatusLine().getStatusCode());
    try{
      EntityUtils.consume(response.getEntity());}
    catch (IOException e){
//      e.printStackTrace();
      logger.error("could not close connection");
    }


  }
}