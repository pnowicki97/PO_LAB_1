package org.example;

public class ExchangeRates {

    public double exchange(Rate source, Rate dest, double amount){
        return amount * source.getMid() / dest.getMid();
    }
}
