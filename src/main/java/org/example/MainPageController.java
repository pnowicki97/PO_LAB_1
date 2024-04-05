package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainPageController {



    @FXML
    TextField sourceAmount;
    @FXML
    TextField destAmount;
    @FXML
    ChoiceBox<Rate> sourceChoiceBox;
    @FXML
    ChoiceBox<Rate> destChoiceBox;

    public void exchange(ActionEvent event) {
        ExchangeRates exchangeRates = new ExchangeRates();
        destAmount.setText(String.valueOf(exchangeRates.exchange(sourceChoiceBox.getValue(),destChoiceBox.getValue(), Double.parseDouble(sourceAmount.getText()))));
        destAmount.setEditable(false);
    }


    public void initialize() throws ParserConfigurationException, IOException, SAXException {
        Parser parser = new Parser();
        RateCollection collection = new RateCollection(parser.parse("https://api.nbp.pl/api/exchangerates/tables/a?format=xml"));
        sourceChoiceBox.setItems(FXCollections.observableList(collection.getRates()));
        destChoiceBox.setItems(FXCollections.observableList(collection.getRates()));
    }
}
