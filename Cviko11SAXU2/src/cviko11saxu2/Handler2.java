/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11saxu2;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Dell
 */
public class Handler2 extends DefaultHandler{
    String text=null;
    Boolean polozka=false, omeleta=false;
    Polozka p=null;
    List<Polozka> polozky=null;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attbs)throws SAXException{
        
        if(localName.equals("recept")){
            text=null;
            omeleta=false;
            polozky=null;
        }
        
        if(localName.equals("polozka")){
            polozka=true;
            if(polozky==null){
                polozky=new ArrayList();
            }
            p = new Polozka();
        }
        
        if(localName.equals("mnozstvo")){
            p.setJednotka(attbs.getValue("jednotka"));
        }
        
            
    }
    
    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException{
        
        if(localName.equals("polozka")){
            polozky.add(p);
            polozka=false;
        }
        
        
        if(localName.equals("nazov") && !polozka){
            if(text.equals("omeleta"))  {
                omeleta=true;
               
            }         
        }
        
       if(localName.equals("nazov") && polozka){
            p.setNazov(text);
        }
        
       if(localName.equals("mnozstvo")){
            p.setMnozstvo(text);    
       }
        
        if(localName.equals("recept")) {
            if(omeleta) {
                for(Polozka p : polozky) {
                    if (p.getNazov().equals("mlieko")) {
                        System.out.println("Mnozstvo mlieka: " + p.getMnozstvo() + " " + p.getJednotka());
                    }
                }
            }
        }
           
        
                
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException{
        text = new String(ch, start, length);
    }
}

