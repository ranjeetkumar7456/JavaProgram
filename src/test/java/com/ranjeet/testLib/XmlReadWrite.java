package com.ranjeet.testLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class XmlReadWrite {
    public static void main(String[] args) throws InterruptedException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            // get Document
            Document document = builder.parse("D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\com\\ranjeet\\testLib\\test.xml");

            NodeList objectList = document.getElementsByTagName("Document");

            for(int i =0;i<objectList.getLength();i++)
            {
                Node object = objectList.item(i);
                if(object.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element objectElement =(Element) object;
                    System.out.println(objectElement);
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
