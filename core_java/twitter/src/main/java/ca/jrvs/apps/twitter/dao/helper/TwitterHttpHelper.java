package ca.jrvs.apps.twitter.dao.helper;

import com.google.gdata.util.common.base.PercentEscaper;
import java.io.IOException;
import java.net.URI;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TwitterHttpHelper implements HttpHelper {

  /**
   * Dependencies are specified as private member variables
   */
  private final OAuthConsumer consumer;
  private final HttpClient httpClient;
  private static final Logger logger = LoggerFactory.getLogger(TwitterHttpHelper.class);

  /**
   * Constructor setup denpendencies using secrets
   *
   * @param consumerKey
   * @param consumerSecret
   * @param accessToken
   * @param tokenSecret
   */

  public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken,
      String tokenSecret) {
    consumer = new CommonsHttpOAuthConsumer(consumerKey,
        consumerSecret);
    consumer.setTokenWithSecret(accessToken, tokenSecret);
    /**
     * Default = single connectionA. Discuss source code if time permit
     */
    httpClient = new DefaultHttpClient();

  }

  /**
   * @param uri
   * @return
   */
  @Override
  public HttpResponse httpPost(URI uri) {
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    HttpPost request = new HttpPost(
        uri + percentEscaper.escape(
            (String) null));

    //sign the request(add headers)
    try {
      consumer.sign(request);
    } catch (Exception e) {
      logger.error("Authentication failed", e);
    }
    //send the request

//    httpClient = HttpClientBuilder.create().build();

    HttpResponse response;
    try {
      response = httpClient.execute(request);
      System.out.println(EntityUtils.toString(response.getEntity()));
      System.out.println("exeuted");
      return response;


    } catch (IOException e) {
      logger.error("could not send request", e);

    }

    return null;
  }

  @Override
  public HttpResponse httpGet(URI uri) {
    HttpGet request = new HttpGet(uri);
    try {
      consumer.sign(request);
      HttpResponse response = httpClient.execute(request);


    } catch (OAuthException | IOException e) {
      throw new RuntimeException(e);
    }

    return null;
  }

  public static void main(String[] args)  {
//
//    String consumerKey= System.getenv("consumerKey");
//    String consumerSecret= System.getenv("consumerSecret");
//    String accessToken = System.getenv("accessToken");
//    String tokenSecret = System.getenv("tokenSecret");
//
//    System.out.println("hi");
//
//    TwitterHttpHelper twitterHelper= new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);
//    try{
//    URI uri= new URI("https://api.twitter.com/1.1/statuses/update.json?status=");
//    twitterHelper.httpPost(uri);
//
//    }
//    catch (URISyntaxException e){
//
//    }
    logger.info("this executes");


  }


}

