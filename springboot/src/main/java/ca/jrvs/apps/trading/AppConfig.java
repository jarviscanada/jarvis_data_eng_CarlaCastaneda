package ca.jrvs.apps.trading;


import ca.jrvs.apps.trading.controller.QuoteController;
import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.service.QuoteService;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);


    @Bean
    MarketDataDao marketDao(HttpClientConnectionManager httpClientConnectionManager,MarketDataConfig marketDataConfig){
        return new MarketDataDao(httpClientConnectionManager,marketDataConfig);
    }
    @Bean
    public MarketDataConfig marketDataConfig(){

        MarketDataConfig marketDataConfig= new MarketDataConfig();

        marketDataConfig.setHost("https://cloud.iexapis.com/v1");
        marketDataConfig.setToken("pk_10744a8e9fa04e8db4b9413668cef3bf");
        return  marketDataConfig;


    }

    @Bean
    public HttpClientConnectionManager  httpClientConnectionManager(  ){
        PoolingHttpClientConnectionManager cm= new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);

        return cm;
    }
    @Bean("MarketDataDao")
    public MarketDataDao marketDataDao(  PoolingHttpClientConnectionManager httpClientConnectionManager,MarketDataConfig marketDataConfig){
       MarketDataDao m= new MarketDataDao(httpClientConnectionManager,marketDataConfig);

        return m;
    }



}
