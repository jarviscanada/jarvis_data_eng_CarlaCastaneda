package ca.jrvs.apps.trading.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IexStock {

    @JsonProperty("quote")
    private IexQuote iexQuote;
    private String symbol;

    public IexQuote getIexQuote() {
        return iexQuote;
    }

    public void setIexQuote(IexQuote iexQuote) {
        this.iexQuote = iexQuote;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
