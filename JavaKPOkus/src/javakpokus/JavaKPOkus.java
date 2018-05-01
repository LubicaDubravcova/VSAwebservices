/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakpokus;

import proxy.NewJerseyClient;

/**
 *
 * @author Dell
 */
public class JavaKPOkus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getPocet());
        System.out.println(client.getKomentar("1"));
        client.postKomentar("tretikomentar");
        System.out.println(client.getPocet());
        System.out.println(client.getKomentar("3"));
        client.deleteKomentar("3");
        System.out.println(client.getPocet());
        System.out.println(client.getPopis());
        client.putPopis("je to nova udalost");
        System.out.println(client.getPopis());
    }
    
}
