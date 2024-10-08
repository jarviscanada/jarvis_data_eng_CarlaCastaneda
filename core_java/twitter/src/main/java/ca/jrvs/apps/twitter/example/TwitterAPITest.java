package ca.jrvs.apps.twitter.example;


import com.google.gdata.util.common.base.PercentEscaper;
import java.io.IOException;
import java.util.Arrays;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterAPITest {

  private static final String CONSUMER_KEY = System.getenv("consumerKey");
  private static final String CONSUMER_SECRET = System.getenv("consumerSecret");
  private static final String ACCESS_TOKEN = System.getenv("accessToken");
  private static final String TOKEN_SECRET = System.getenv("tokenSecret");

  private static final Logger logger = LoggerFactory.getLogger(TwitterAPITest.class);

  public static void main(String[] args) {
    //setup oauth

    OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

    // create an HTTP GET request
    String status = "today is a good day";
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    HttpPost request = new HttpPost(
        "https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status));

    //sign the request(add headers)
    try {
      consumer.sign(request);
    } catch (Exception e) {
      logger.error("Authentication failed", e);
    }

    System.out.println("Http Request Headers:");
    Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

    //send the request

    HttpClient httpClient = HttpClientBuilder.create().build();

    HttpResponse response;
    try {
      response = httpClient.execute(request);
      System.out.println(EntityUtils.toString(response.getEntity()));

    } catch (IOException e) {
      logger.error("could not send request", e);

    }


  }

}
