/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@XmlRootElement(name = "osoba", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
public class Osoba {
    private String gen;
    private String meno;
    private String bydlisko;
    private String email;

    @XmlAttribute(name="gen", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
    
    @XmlElement(name = "meno", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }
    
    @XmlElement(name = "bydlisko", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public String getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }

    @XmlElement(name = "email", namespace = "http://xml.netbeans.org/schema/AdresarSchema")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Osoba() {
    }

    public Osoba(String gen, String meno, String bydlisko, String email) {
        this.gen = gen;
        this.meno = meno;
        this.bydlisko = bydlisko;
        this.email = email;
    }

    public Osoba(String gen, String meno, String bydlisko) {
        this.gen = gen;
        this.meno = meno;
        this.bydlisko = bydlisko;
    }
    
    
}
