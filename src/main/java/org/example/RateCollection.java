package org.example;

import java.util.List;
import java.util.function.Predicate;

public class RateCollection {

    public RateCollection(List<Rate> rates) {
        this.rates = rates;
    }

    private List<Rate> rates = null;

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Rate getRate(Rate rate){
        return rates.stream().filter(r -> { return r.equals(rate);}).findAny().orElse(null);
    }
}
