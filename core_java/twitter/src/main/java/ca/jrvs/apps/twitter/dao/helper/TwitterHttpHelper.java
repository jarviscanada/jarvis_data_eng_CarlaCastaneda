package ca.jrvs.apps.twitter.dao.helper;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
@org.springframework.stereotype.Component

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
     * Default = single connection. A Discuss source code if time permit
     */
    httpClient = new DefaultHttpClient();

  }
  public TwitterHttpHelper(){

//    String consumerKey = System.getenv("consumerKey");
//    String consumerSecret = System.getenv("consumerSecret");
//    String accessToken = System.getenv("accessToken");
//    String tokenSecret = System.getenv("tokenSecret");

      String consumerKey = "o6mPobtw22rgWjzyBEJL82asi";
      String consumerSecret= "mZ3OMzDTqk4TkFSWhGjeCSG81qOgcPbNRIbYxv8yzTr3qdXWK0";
      String accessToken="1554530689961414658-suwxbNjzz3tg8sdXJM0ystmtQ30CQL";
      String tokenSecret="VuTJnSKodclFnkpTgJDfODjSO3b8RZCjwoU6LBFnblp6Z";
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
    HttpResponse response = fetchResponse(uri, HttpMethod.POST);

    return  response;
  }

  private HttpResponse fetchResponse(URI uri, HttpMethod method) {

    if (method == HttpMethod.GET) {

      HttpGet request = new HttpGet(uri);

      try {
        consumer.sign(request);
        HttpResponse response = httpClient.execute(request);
      return response;


      } catch (OAuthException | IOException e) {
        logger.error("Authentication error", e.getMessage());

      }


    } else if (method == HttpMethod.POST) {
      HttpPost request = new HttpPost(uri);
      HttpResponse response;

      try {
        consumer.sign(request);

       response = httpClient.execute(request);
       return response;



      } catch (OAuthException | IOException e) {
        logger.error("Authentication error", e.getMessage());
      }


    } else {
      logger.error("can only handle get and post requests");
    }
    return null;


  }

  @Override
  public HttpResponse httpGet(URI uri) {
    HttpResponse response = fetchResponse(uri, HttpMethod.GET);
//    try{
//      EntityUtils.consume(response.getEntity());
//    }catch (IOException e){
//      logger.error("could not close connection");
//    }
    return response;

  }

//  public static void main(String[] args) {
//
//  }




}

