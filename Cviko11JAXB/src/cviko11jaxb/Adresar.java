/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11jaxb;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@XmlRootElement(name="adresar", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
public class Adresar {
    private LinkedList<Osoba> adresar=new LinkedList<>();

    @XmlElement(name="osoba", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public LinkedList<Osoba> getAdresar() {
        return adresar;
    }

    public void setAdresar(LinkedList<Osoba> adresar) {
        this.adresar = adresar;
    }

    public Adresar() {
    }
    
    
}
