package com.ranjeet.testLib;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;


public class XmlReadWriteNew {
   // public static void main(String[] args) throws InterruptedException {

    public static void display()
    {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            // get Document
            Document d = db.parse("D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\com\\ranjeet\\testLib\\test.xml");

            //NodeList objectList = document.getElementsByTagName("Document");
            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList)xp.compile("/GetRetailStore/RetailStoreData/Abs:StoreCheckStandData").evaluate(d, XPathConstants.NODESET);
            System.out.println("Number of data : "+nl.getLength());

            /*for(int i =0;i<objectList.getLength();i++)
            {
                Node object = objectList.item(i);
                if(object.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element objectElement =(Element) object;
                    System.out.println(objectElement);
                }
            }*/
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }
    //}
}
