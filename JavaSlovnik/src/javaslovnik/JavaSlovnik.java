/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaslovnik;

import proxy.NewJerseyClient;

/**
 *
 * @author Dell
 */
public class JavaSlovnik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client = new NewJerseyClient();
        System.out.println(client.getText("flower"));
        client.putText("cat", "macka");
        System.out.println(client.getText("cat"));
        client.deleteText("cat");
        System.out.println(client.getText("cat"));
    }
    
}
