package domPars;


import info.Sonnet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class ParserDom {

    public void DomParser(File file) throws IOException {

        Sonnet sonnet = new Sonnet();

        DocumentBuilderFactory docBuild = DocumentBuilderFactory.newInstance();
        Document doc = null;

        try {
            doc = docBuild.newDocumentBuilder().parse(file);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Something was wrong.." + e);
        }

        NodeList nodeList = doc.getElementsByTagName("sonnet");
        Node sonnetNode = nodeList.item(0);
        nodeList = sonnetNode.getChildNodes();

        String fileName = null;

        if (sonnetNode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) sonnetNode;
            fileName = element.getElementsByTagName("firstName").item(0).getTextContent() + "_" +
                    element.getElementsByTagName("lastName").item(0).getTextContent() + "_";
        }

        File newFile = null;
        sonnetNode = nodeList.item(3);
        if (sonnetNode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) sonnetNode;
            newFile = new File("src/" + fileName + element.getTextContent() + ".txt");
        }

        sonnetNode = nodeList.item(5);
        nodeList = sonnetNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            sonnetNode = nodeList.item(i);
            FileWriter fw = new FileWriter(newFile, true);
            if (sonnetNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) sonnetNode;
                fw.write(element.getTextContent() + "\n");
            }
            fw.close();
        }
    }
}


