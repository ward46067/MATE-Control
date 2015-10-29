package Util;

import static Util.var.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import processing.data.XML.*;

public class XML {
    public static void XML(){
        try {
            
            //locate xml file
            File xmlFile = new File("lib\\data\\palette.xml");
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(xmlFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            
            System.out.println("Found xml");
            while(eventReader.hasNext()){    
                XMLEvent event = eventReader.nextEvent();
                
                if(event.isStartElement()){
                    StartElement startElement = event.asStartElement();
                    
                    if(startElement.getName().getLocalPart().equals("colorset")){
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        
                        while(attributes.hasNext()){
                            Attribute attribute = attributes.next();
                            if(attribute.getName().toString().equals("color")){
                                System.out.println("Found colors");
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
