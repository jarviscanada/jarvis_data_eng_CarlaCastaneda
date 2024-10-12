package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Service
public class QuoteService {

    private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

//    QuoteDao quoteDao,
    @Autowired
    public QuoteService( QuoteDao quoteDao,MarketDataDao marketDataDao ){
        this.quoteDao = quoteDao;
        this.marketDataDao= marketDataDao;
    }

    /**
     * Update quote table against the IEX Source
     * - get all quotes from the db
     * - forEach ticker get iexQuote
     * - convert iexQuote to quote entity
     * - persists quote to db
     *
     * @throws ca.jrvs.apps.trading.dao.ResourceNotFoundException if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrive data
     * @throws IllegalArgumentException for invalid input
     */
    public void updateMarketData(){

    }

    /**
     * Helper method. Map a IexQuote to a Quote entity.
     * Note: `iexQuote.getLatestPrice() == null` if the stock market is closed.
     * Make sure set a default value for number of field(s).
     * @param iexQuote
     * @return Quote object from iexQuote
     */

    protected static Quote buildQuoteFromIexQuote(IexQuote iexQuote){
        Quote mapQuote = new Quote();

        if (iexQuote.getLastPrice()==null){
            mapQuote.setAskPrice(0.0);
            mapQuote.setAskSize( 0);
            mapQuote.setBidPrice( 0.0);
            mapQuote.setBidSize(0);
            mapQuote.setLastPrice(0.0);
            mapQuote.setTicker("null");


        }
        else{
            mapQuote.setAskPrice(iexQuote.getAskPrice());
            mapQuote.setAskSize( iexQuote.getAskSize());
            mapQuote.setBidPrice( iexQuote.getBidPrice());
            mapQuote.setBidSize(iexQuote.getBidSize());
            mapQuote.setLastPrice(iexQuote.getLastPrice());
            mapQuote.setTicker(iexQuote.getTicker());


        }



        return mapQuote;

    }

    /**
     *  Validate (against IEX) and save given tickers to quote table
     *
     *   - Get iexQuote(s)
     *   - convert each iexQuote to Quote entity
     *   - persist the quote to db
     * @param tickers a list of tickers/symbols
     * @return
     * @throws IllegalArgumentException if ticker is not found from IEX
     */

    public List<Quote> saveQuotes(List<String> tickers){
        List<Quote> quotes=new ArrayList<>();

        for (String ticker:tickers){
            Quote quote=saveQuote(ticker);
            quotes.add(quote);
            quoteDao.save(quote);


        }
        return quotes;


    }

    /**
     *  helper method  for save Quotes
     * @param ticker id
     * @return Quote
     */
    public Quote saveQuote(String ticker){
        IexQuote iexQuote=findIexQuoteByTicker(ticker);
        Quote quote=buildQuoteFromIexQuote(iexQuote);


        return quote;


    }

    /**
     * Find an IexQuote
     * @param ticker id
     * @return IexQuote object
     * @throws IllegalArgumentException if ticker is invalid
     */

    public IexQuote findIexQuoteByTicker(String ticker){
        return marketDataDao.findById(ticker)
                .orElseThrow(()-> new IllegalArgumentException(ticker+ "is invalid"));
    }

    /**
     *  Update a given quote to quote table without validation
     * @param quote entity
     * @return
     */

    public Quote saveQuote(Quote quote){
        return quoteDao.save(quote);
    }

    /**
     * Find all quotes from the quote table
     * @param
     * @return a list of quotes
     */

    public List<Quote> findAllQuotes(){
        return quoteDao.findAll();
    }
}
