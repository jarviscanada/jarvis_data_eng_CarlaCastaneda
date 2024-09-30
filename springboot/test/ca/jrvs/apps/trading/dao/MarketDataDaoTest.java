package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import junit.framework.TestCase;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MarketDataDaoTest extends TestCase {
    private MarketDataDao dao;

    @Before
    public void init(){
        PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        MarketDataConfig marketDataConfig = new MarketDataConfig();
        marketDataConfig.setHost("https://cloud.iexapis.com/v1/");

        marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));
        this.dao = new MarketDataDao(cm,marketDataConfig);

    }
//    @Test
//    public void testFindById() {
//        PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
//        cm.setMaxTotal(50);
//        cm.setDefaultMaxPerRoute(50);
//        MarketDataConfig marketDataConfig = new MarketDataConfig();
//        marketDataConfig.setHost("https://cloud.iexapis.com/v1");
//
//        marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));
//        this.dao = new MarketDataDao(cm,marketDataConfig);
//        String ticker= "AAPL";
//        IexQuote iexQuote = this.dao.findById(ticker).get();
//        System.out.println(iexQuote.toString());
//        assertEquals(ticker, iexQuote.getTicker());
//    }

    @Test
    public void testFindAllById() {
        PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        MarketDataConfig marketDataConfig = new MarketDataConfig();
        marketDataConfig.setHost("https://cloud.iexapis.com/v1/");
        marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));

        this.dao = new MarketDataDao(cm,marketDataConfig);

        List<IexQuote> quoteList = (List<IexQuote>) this.dao.findAllById(Arrays.asList("AAPL","FB"));
        assertEquals(2,quoteList.size());
        assertEquals("AAPL",quoteList.get(0).getTicker());

    }
}