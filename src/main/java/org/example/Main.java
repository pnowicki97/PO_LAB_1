package org.example;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        launch();
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

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}