/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11jaxb;


import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author Dell
 */
public class Cviko11JAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Adresar.class);
        Unmarshaller um = context.createUnmarshaller();
        Adresar adresar = (Adresar) um.unmarshal(new File("C:\\Users\\Dell\\Desktop\\adresar.xml"));
        
        for (Osoba o:adresar.getAdresar())
            System.out.println(o.getMeno());
        System.out.println("-------------------");
        
        for (Osoba o:adresar.getAdresar()){
            if (o.getGen()=="zena")
                System.out.println(o.getMeno());
        }
         System.out.println("-------------------"); 
        for (Osoba o:adresar.getAdresar())
            if (o.getBydlisko()!=null)
                System.out.println(o.getBydlisko());
        System.out.println("-------------------");
       
        
    }
   
}
