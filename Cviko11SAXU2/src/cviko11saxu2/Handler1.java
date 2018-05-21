/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11saxu2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Dell
 */
public class Handler1 extends DefaultHandler{
    
    String text, nazovReceptu, nazovPolozky, mnozstvo, jednotka;
    Boolean polozka=false, muka=false;
    
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrbs) throws SAXException{
        if(localName.equals("recept")){
            nazovPolozky=null;
            nazovReceptu=null;
            mnozstvo=null;
            jednotka=null;
            text=null;
        }
        
        if(localName.equals("polozka")){
            polozka=true;
        }
        
        if(localName.equals("mnozstvo")){
            jednotka=attrbs.getValue("jendotka");
        }
        
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(localName.equals("polozka")){
            polozka=false;
        }
        
        if(localName.equals("nazov") && polozka){
            nazovPolozky=text;
            if(nazovPolozky.equals("muka"))
                muka=true;
        }
        
        if(localName.equals("nazov") && !polozka){
            nazovReceptu=text;
            //System.out.println(nazovReceptu);
        }
        
        if(localName.equals("recept")){
            if(muka)
                System.out.println(nazovReceptu);
            muka=false;
        }
            
    }
    
    @Override
    public void characters(char[] ch, int start, int length)throws SAXException{
        text=new String(ch, start, length);
    }
    
}
