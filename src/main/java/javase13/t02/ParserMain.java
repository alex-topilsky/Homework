package javase13.t02;

import javase13.t02.DOM.MyDOMParser;
import javase13.t02.SAX.SAXParser;
import javase13.t02.StAX.StAXParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import static java.lang.System.out;

    /*
    Проанализировать данный xml тремя видами парсеров: SAX, StAX и DOM
    */
public class ParserMain {
    public static void main(String[] args) {
        //SAX parser
        out.println("SAX parser");
        SAXParser saxParser = new SAXParser();
        try {
            saxParser.start();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("");

        //StAX parser:
        out.println("StAX parser:");
        StAXParser staxParser = new StAXParser();
        try {
            saxParser.start();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("");

        //DOM parser:
        out.println("DOM parser:");
        MyDOMParser myDOMParser = new MyDOMParser();
        try {
            myDOMParser.start();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
