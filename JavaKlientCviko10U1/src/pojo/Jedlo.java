/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@XmlRootElement(name="menu")
public class Jedlo {
    private String nazov;
    private double cena;

    public String getNazov() {
        return nazov;
    }
    @XmlElement(name="nazov")
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Jedlo(String nazov, double cena) {
        this.nazov = nazov;
        this.cena = cena;
    }

    public Jedlo() {
    }
    
    
    
}
