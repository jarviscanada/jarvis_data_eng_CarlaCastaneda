package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.AppConfig;
import ca.jrvs.apps.trading.model.domain.Entity;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import javax.persistence.Id;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
@Sql({"classpath:scheme.sql"})
@ComponentScan(basePackages = {"ca.jrvs.apps.trading.dao","ca.jrvs.apps.trading.model.domain"})
public class QuoteDaoIntTest  {

    @Autowired
    private QuoteDao quoteDao;
    private Quote savedQuote;

    @Before
    public void insertOne(){
//        Quote savedQuote = new Quote();
//        this.savedQuote=savedQuote;
        this.savedQuote.setAskPrice(10d);
        this.savedQuote.setAskSize(10);
        this.savedQuote.setBidPrice(10.2d);
        this.savedQuote.setBidSize(10);
        this.savedQuote.setId("aapl");
        this.savedQuote.setLastPrice(10.1d);
        this.quoteDao.save(this.savedQuote);


    }

    @After
    public void deleteOne(){
        this.quoteDao.deleteById(this.savedQuote.getId());

    }

    @Test

    public void existsById(){

        this.quoteDao.existsById(this.savedQuote.getTicker());


    }

}