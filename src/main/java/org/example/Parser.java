package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Rate> parse(String url) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        URLConnection connection = new URL(url).openConnection();
        connection.addRequestProperty("Accept", "application/xml");
        Document document = builder.parse(connection.getInputStream());
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("Rate");
        List<Rate> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String currency = element.getElementsByTagName("Currency").item(0).getTextContent();
            String code = element.getElementsByTagName("Code").item(0).getTextContent();
            double mid = Double.parseDouble(element.getElementsByTagName("Mid").item(0).getTextContent());
            list.add(new Rate(currency,code,mid));
        }
        return list;
    }

}
