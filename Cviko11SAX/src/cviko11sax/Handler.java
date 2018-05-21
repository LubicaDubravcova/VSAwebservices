/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11sax;

import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Dell
 */
public class Handler extends DefaultHandler {

    private String meno,bydlisko,pohlavie,text;
    private boolean osoba;
    Set<String> distinctCity=new HashSet<>();
    Set<String> distinctMeno=new HashSet<>();
    Set<String> duplikaty=new HashSet<>();
    
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        if(localName.equals("osoba")) {
            pohlavie = atrbts.getValue("gen");
            osoba=true;
            meno=null;
            bydlisko=null;
            text=null;
        }
       
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
                
        //vypíšte mená všetkých osôb
        if(localName.equals("meno")) {
           meno = text;
           System.out.println(meno);
           if(!distinctMeno.contains(meno)){
               distinctMeno.add(meno);
           }
           else
               duplikaty.add(meno);
        }
        
        //vypíšte mená všetkých žien
        if(localName.equals("osoba")) {
            if(("zena").equals(pohlavie))
                System.out.println(meno);           
        }
        
        //vypíšte mená všetkých miest (bydlisko) v ktorých niekto býva, bez opakovania.
        if(localName.equals("bydlisko")) {
            bydlisko = text;   
            distinctCity.add(bydlisko);
            
        }
        
        if(localName.equals("adresar")) {
            for(String mesto:distinctCity)
                System.out.println(mesto);
        }
        
        //zistite či v súbore nie sú dve osoby s rovnakým menom.
        if(localName.equals("adresar")) {
            if(duplikaty.isEmpty())
                System.out.println("Nie su duplikaty");
            else{
                System.out.println("Duplikaty su v tychto menach/mene: ");
                for(String mena:duplikaty)
                System.out.println(mena);
            }
                
            
        }
    }

   
     @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       text = new String(ch, start, length); 
         
      
    }
    
}