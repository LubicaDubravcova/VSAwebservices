/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("generic")
@Singleton
public class GenericResource {

    @Context
    private UriInfo context;
    private TreeMap<Integer,String> menu;

   /* public GenericResource(Map<Integer, String> menu) {
        this.menu = menu;
    }
    */
    
    public GenericResource() { 
        //menu = new HashMap<>();
        menu=new TreeMap<>();
        menu.put(0,"Halusky");
        menu.put(1,"Rezen");
        menu.put(2,"Gulas");
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        String all = "";
        for(Entry<Integer,String> entry: menu.entrySet())
           all=all+entry.getValue()+" ";
        return all;
    }
     

   
    @GET
    @Path("/{index: [0-9]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMenu(@PathParam("index") int x ) {
       return menu.get(x);
    }

    
    @PUT
    @Path("{index: [0-9]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putMenu(@PathParam("index") int x, String content) {
        menu.put(x,content);
    }
    
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String postMenu(String content) {
        int index = menu.lastKey();
        menu.put(index+1,content);
        return ""+index;
          
    }
    
    @DELETE
    @Path("{index: [0-9]+}")
    public void deleteMenu(@PathParam("index") int x) {
        if (x<menu.size())
            menu.remove(x);
    }

}
