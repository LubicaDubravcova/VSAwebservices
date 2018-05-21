/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko11saxu2;

/**
 *
 * @author Dell
 */
public class Polozka {
    private String nazov;
    private String mnozstvo;
    private String jednotka;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(String mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public String getJednotka() {
        return jednotka;
    }

    public void setJednotka(String jednotka) {
        this.jednotka = jednotka;
    }

    public Polozka() {
    }

    public Polozka(String nazov, String mnozstvo, String jednotka) {
        this.nazov = nazov;
        this.mnozstvo = mnozstvo;
        this.jednotka = jednotka;
    }
    
    
}
