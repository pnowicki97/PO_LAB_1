import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

public class RemoteDocParser {

    public void getFormat(String url) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        URLConnection connection = new URL(url).openConnection();
        Document document = builder.parse(connection.getInputStream());
        document.getDocumentElement().normalize();

        System.out.println(document.getDocumentElement().getNodeName());
        System.out.println((document.getDocumentElement().getAttribute("Table")));
    }
}
