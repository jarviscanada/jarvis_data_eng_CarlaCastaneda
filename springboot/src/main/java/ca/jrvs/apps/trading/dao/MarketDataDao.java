package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.util.*;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class MarketDataDao implements CrudRepository <IexQuote, String> {

    private static final String IEX_BATCH_PATH="/stock/market/batch?symbols=";
    private static final String IEX_PATH_TOKEN="&types=quote&token=";
    private String IEX_BATCH_URL;
    Optional <IexQuote>  iexQuote;
    MarketDataConfig marketDataConfig;


    private static final  Logger logger= LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;

    @Autowired
    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager,
                         MarketDataConfig marketDataConfig){
        this.httpClientConnectionManager = httpClientConnectionManager;
        this.marketDataConfig=marketDataConfig;
        IEX_BATCH_URL=marketDataConfig.getHost() + IEX_BATCH_PATH + IEX_PATH_TOKEN+marketDataConfig.getToken();

    }


    @Override
    public <S extends IexQuote> S save(S entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<IexQuote> findById(String ticker) {
        List<IexQuote> quotes= (List<IexQuote>) findAllById(Collections.singletonList(ticker));


        if (quotes.size() ==0){
            return Optional.empty();
        }else if (quotes.size()==1){
            iexQuote = Optional.of(quotes.get(0));

        }else{
            throw new DataRetrievalFailureException("Unexpected number of quotes");
        }

        return iexQuote;
    }

    @Override
    public boolean existsById(String s) {
        throw new UnsupportedOperationException("Not implemented");
    }


    @Override
    public Iterable<IexQuote> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<IexQuote> findAllById(Iterable<String> tickers) {
        List<IexQuote> iexQuoteList = new ArrayList<>();
        StringBuilder  tickersUri= new StringBuilder();
        ArrayList<String> tickerArr = new ArrayList<>();

        for (String ticker:tickers){
            tickersUri.append(ticker+",");
            tickerArr.add(ticker);
        }

        IEX_BATCH_URL=marketDataConfig.getHost() + IEX_BATCH_PATH +tickersUri.toString()+ IEX_PATH_TOKEN+marketDataConfig.getToken();
        System.out.println("IEX_BATCH_URL:"+IEX_BATCH_URL);

        String response = null;
        try {
            response = executeHttpGet(IEX_BATCH_URL).orElseThrow(()-> new IllegalArgumentException("Invalid ticker"));
        } catch (IOException e) {
            logger.error(e.getMessage());

        }
        System.out.println("response:"+response);


        JSONObject IexQuotesJson = new JSONObject(response);
        System.out.println(IexQuotesJson.toString());


        for (String t:tickerArr){
            JSONObject innerObject = IexQuotesJson.getJSONObject(t);
            System.out.println(innerObject.toString());
            JSONObject innerInObject = innerObject.getJSONObject("quote");
            System.out.println(innerInObject .toString());
            ObjectMapper mapper= new ObjectMapper();
            try {
                IexQuote iexQuote=mapper.readValue(innerInObject .toString(),IexQuote.class);
                System.out.println("fdsfdsfsd");
                System.out.println(iexQuote);

                iexQuoteList.add(iexQuote);

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (IexQuotesJson.length()==0){
                throw new IllegalArgumentException("Invalid ticker");
            }


        }

        return iexQuoteList;
    }

    @Override

    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }


    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(IexQuote entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }


    private Optional<String> executeHttpGet (String url) throws IOException {
        Optional<String> iexQuote = null;

        HttpGet request= new HttpGet(url);
        ObjectMapper mapper= new ObjectMapper();


        CloseableHttpClient httpClient= getHttpClient();
        System.out.println("url:"+url);


        try{
            System.out.println("xecuteHttpGet: try statemet");

            CloseableHttpResponse httpResponse = httpClient.execute(request)  ;

            try {
//                IexQuote iexObj= mapper.readValue(httpResponse.toString(),IexQuote.class);
                iexQuote= Optional.of(EntityUtils.toString(httpResponse.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            iexQuote= Optional.ofNullable(EntityUtils.toString((HttpEntity) httpResponse));

        }catch(Exception e){
            System.out.println("xecuteHttpGet: catch statemet");
            logger.error(e.getMessage());


        }

        
        return iexQuote;
    }
    private CloseableHttpClient getHttpClient(){
        return HttpClients.custom()
                .setConnectionManager(httpClientConnectionManager)
                .setConnectionManagerShared(true)
                .build();
    }
}
