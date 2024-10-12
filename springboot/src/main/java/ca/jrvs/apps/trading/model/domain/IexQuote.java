package ca.jrvs.apps.trading.model.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * https://iexcloud.io/docs/api/#quote
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonPropertyOrder({
        "iexAskPrice",
        "iexAskSize",
        "iexBidPrice",
        "iexBidSize",
        "symbol",
        "latestPrice",
        "companyName"


})

public class IexQuote {


    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("iexAskPrice")
    private Double askPrice;
    @JsonProperty("iexAskSize")
    private Integer askSize;
    @JsonProperty("iexBidPrice")
    private Double bidPrice;
    @JsonProperty("iexBidSize")
    private Integer bidSize;
    @JsonProperty("latestPrice")
    private Double lastPrice;
    @JsonProperty("symbol")
    private String ticker;
    private String id;

    @JsonProperty("companyName")
    public void setCompanyName(String name){ this.companyName= name; }
    @JsonProperty("companyName")
    public String getCompanyName(){ return this.companyName; }
    @JsonProperty("symbol")
    public void setTicker(String symbol){this.ticker= symbol;
    this.setID(this.ticker);}
    @JsonProperty("symbol")
    public String getTicker(){
        return this.id;

    }
    public String getId(){
        return this.id;
    }
    @JsonProperty("latestPrice")
    public void setLastPrice(Double latestPrice){
        this.lastPrice=latestPrice;

    }
    @JsonProperty("latestPrice")
    public Double getLastPrice(){
        return this.lastPrice;
    }
    @JsonProperty("iexAskPrice")
    public void setAskPrice(Double iexAskPrice) {

        this.askPrice = iexAskPrice;
    }

    @JsonProperty("iexAskPrice")
    public Double getAskPrice() {
        return this.askPrice;
    }
    @JsonProperty("iexAskSize")
    public void setAskSize(int iexAskSize) {
        this.askSize = iexAskSize;
    }

    @JsonProperty("iexAskSize")
    public int getAskSize() {
        return this.bidSize;
    }

    @JsonProperty("iexBidSize")
    public void setBidSize(int iexBidSize) {
        this.bidSize = iexBidSize;
    }

    @JsonProperty("iexBidSize")
    public int getBidSize() {
        return this.bidSize;
    }

    @JsonProperty("iexBidPrice")
    public void setBidPrice(Double iexBidPrice) {
        this.bidPrice = iexBidPrice;
    }

    @JsonProperty("iexBidPrice")
    public Double getBidPrice() {
        return this.bidPrice;
    }

    private void setID(String id){
        this.id=id;


    }
    public String toString(){
        return "symbol:"+this.ticker+",/n"
                +"companyName:"+ this.companyName+",/n"
                +"askPrice:"+ this.askPrice+",/n"
                +"askSize:"+this.askSize+",/n"
                +"bidPrice:"+this.bidPrice+",/n"
                +"bidSize:"+this.bidSize+",/n"
                +"latestPrice:"+this.lastPrice+",/n";
    }



}
