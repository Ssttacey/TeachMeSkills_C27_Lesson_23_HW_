package saxPars;

import info.Sonnet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParserSax {

    public static void SaXParser(File file) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Open SAX parsing error" + e);
        }

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println(" SAX parsing error" + e);
        } catch (IOException e) {
            System.out.println("IO parsing error " + e);
        }
    }
}
