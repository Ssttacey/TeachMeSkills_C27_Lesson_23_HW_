package saxPars;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaxParserHandler extends DefaultHandler {

    private boolean isTitle = false;
    private boolean isLastName = false;
    private boolean isFirstName = false;
    private boolean isLine = false;

    public StringBuilder data = null;
    public String fileName;

    File fl = null;


    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("lastName")) {
            isLastName = true;
        } else if (qName.equalsIgnoreCase("firstName")) {
            isFirstName = true;
        } else if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("line")) {
            isLine = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isLastName) {
            fileName = data.toString() + "_" ;
            isLastName = false;
        }
        else if (isFirstName) {
            fileName = data.toString() + "_" + fileName + ".txt";
            isFirstName = false;
        } else if (isTitle) {
            fileName = data.toString() + "_" + fileName;
            isTitle = false;

        } else if (isLine) {
            FileWriter fw;
            try {
                fl = new File("src/" + fileName);
                fw = new FileWriter(fl, true);
                fw.write(data.toString() + "\n");
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            isLine = false;
        }

    }


    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
