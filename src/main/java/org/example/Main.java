package main.java.org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Parser parser = new Parser();
        RateCollection collection = new RateCollection(parser.parse("https://api.nbp.pl/api/exchangerates/tables/a?format=xml"));

        System.out.println(collection.getRates());
        Rate rate = new Rate();
        rate.setCode("USD");
        System.out.println( collection.getRate(rate));
        Rate dest = new Rate();
        dest.setCode("EUR");
        ExchangeRates exchange = new ExchangeRates();
        System.out.println(exchange.exchange(collection.getRate(rate),collection.getRate(dest),10));
    }
}