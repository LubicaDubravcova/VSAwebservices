/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaklientcv9mapa;

import proxy.NewJerseyClient;

/**
 *
 * @author Dell
 */
public class JavaKlientCV9mapa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getAll());
        client.putMenu("langos", "0");
        System.out.println(client.getAll());
        client.postMenu("zmrzlina");
        System.out.println(client.getAll());
        client.deleteMenu("1");
        System.out.println(client.getAll());
        
    }
    
}
