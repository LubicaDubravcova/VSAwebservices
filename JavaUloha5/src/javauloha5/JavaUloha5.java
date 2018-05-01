/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javauloha5;

import proxy.NewJerseyClient;

/**
 *
 * @author Dell
 */
public class JavaUloha5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client= new NewJerseyClient();
        //System.out.println(client.getPocet("Str"));
        //client.postJedlo("knedla", "Pon");
        System.out.println(client.getPocet("Pon"));
        System.out.println(client.getJedlo("Pon", "1"));
        client.putJedlo("Pon","1","orechy");
        //client.deleteJedlo("Pon", "1");
        System.out.println(client.getPocet("Pon"));
        System.out.println(client.getJedlo("Pon", "1"));
    }
    
}
