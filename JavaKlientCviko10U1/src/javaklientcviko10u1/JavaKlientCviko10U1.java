/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaklientcviko10u1;

import pojo.Jedlo;
import proxy.NewJerseyClient;

/**
 *
 * @author Dell
 */
public class JavaKlientCviko10U1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJerseyClient client= new NewJerseyClient();
        Jedlo j= client.getPolozka(Jedlo.class, "2");
        System.out.println(j.getNazov());
        
        
      
        Jedlo j2 =new Jedlo("polievka",2.3);
       // client.putPolozka(j2,"1");
        
        client.postJedlo(j2, Jedlo.class);
        //System.out.println(client.postJedlo(j2, Jedlo.class));
        System.out.println(client.getPonuka());
        client.deletePolozka("1");
        System.out.println(client.getPonuka());
        
    }
    
    
}
