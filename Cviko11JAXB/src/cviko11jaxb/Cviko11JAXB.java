/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11jaxb;


import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
       // Adresar adresar = (Adresar) um.unmarshal(new File("adresar.xml"));
       Adresar adresar = (Adresar) um.unmarshal(new File("test.xml"));
        
        for (Osoba o:adresar.getAdresar())
            System.out.println(o.getMeno());
        
        
        System.out.println("-------------------");
        
        for (Osoba o:adresar.getAdresar()){
            if (o.getGen().compareTo("zena")==0)
                System.out.println(o.getMeno());
        }
        
        
        System.out.println("-------------------"); 
        
        Set<String> distinctBydliska = new HashSet<>();
        for (Osoba o:adresar.getAdresar())
            if (o.getBydlisko()!=null)
                distinctBydliska.add(o.getBydlisko());
        for (String city:distinctBydliska)
            System.out.println(city);
        
        
        System.out.println("-------------------");
        
        Set<String> distinctMena=new HashSet<>();
        Set<String> duplikaty =new HashSet<>();
        
        for (Osoba o:adresar.getAdresar()){ 
            if (!distinctMena.contains(o.getMeno()))
                distinctMena.add(o.getMeno());
            else
                duplikaty.add(o.getMeno());
        }
        if (duplikaty.isEmpty())
            System.out.println("Nie su ziadne duplikaty");
        else{
            System.out.println("Su duplikaty. Tieto mena/meno sa nachadza viackrat:"); 
            for(String meno:duplikaty)
                System.out.println(meno);
            }
        
       
        
        //-------------------VYTVORENIE XML-----------------------
        /*LinkedList<Osoba> adresar=new LinkedList<>();
             
        Osoba o=new Osoba("zena","Zuzana Kratochvilova","Bratislava");
        Osoba o2=new Osoba("muz","Igor Vdovec","Puchov");
        Osoba o3=new Osoba("muz","Igor Vdovec","Puchov");
        adresar.add(o);
        adresar.add(o2);
        adresar.add(o3);
        
        Adresar a1=new Adresar();
        a1.setAdresar(adresar);
     
        JAXBContext context = JAXBContext.newInstance(Adresar.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(a1, System.out);
        m.marshal(a1, new File("test.xml"));*/
       
        
    }
   
}
