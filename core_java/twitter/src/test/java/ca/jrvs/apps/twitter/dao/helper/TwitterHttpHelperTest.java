package ca.jrvs.apps.twitter.dao.helper;

import java.net.URI;
import java.net.URISyntaxException;
import junit.framework.TestCase;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterHttpHelperTest extends TestCase {
  private HttpHelper httpHelper;
  @BeforeClass
  public void setup() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");

    httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken,
        tokenSecret);

  }



  @Test
  public void httpPost() throws Exception {
    HttpResponse response = httpHelper.httpPost(new URI ("https://api.twitter.com/1.1/statuses/update.json?status=Hi%20I%20am%20in%20Spain!"));
    System.out.println(EntityUtils.toString(response.getEntity()));

  }

  @Test
  public void httpGet() throws Exception{
    HttpResponse response=httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=CarlaCa01239209"));
    System.out.println(EntityUtils.toString(response.getEntity()));

  }
}