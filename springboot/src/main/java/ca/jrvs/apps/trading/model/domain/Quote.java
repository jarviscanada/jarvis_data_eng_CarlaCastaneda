package ca.jrvs.apps.trading.model.domain;

import javax.persistence.Id;

public class Quote implements Entity<String>{

    // ticker is id primary key
    private String ticker;
    private Double lastPrice;
    private Double bidPrice;
    private Integer bidSize;
    private Double askPrice;
    private Integer askSize;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String getId(){
        return ticker;
    }


    @Override
    public void setId(Id id) {


    }
}
