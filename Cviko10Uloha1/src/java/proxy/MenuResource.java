/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

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
import pojo.Jedlo;

/**
 * REST Web Service
 *
 * @author Dell
 */
@Path("menu")
@Singleton
public class MenuResource {

    @Context
    private UriInfo context;
    //private Map<Integer,Jedlo> menu;
    private TreeMap<Integer,Jedlo> menu;
    /**
     * Creates a new instance of MenuResource
     */
    public MenuResource() {
        //menu = new HashMap<>();
        menu = new TreeMap<>();
        menu.put(1, new Jedlo("halusky",3.2));
        menu.put(2, new Jedlo("palacinky",5.0));
        menu.put(3, new Jedlo("langos",1.2));
    }

  
    @GET
    @Path("/{index:[0-9]+}")
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo getPolozka(@PathParam("index") int index) {
        if(menu.containsKey(index))
            return menu.get(index);     
        else 
            return null;
    }

   
    @PUT
    @Path("/{index:[0-9]+}")
    @Consumes(MediaType.APPLICATION_XML)
    public void putPolozka(@PathParam("index") int index, Jedlo content) {
        if(menu.containsKey(index))
            menu.put(index,content);
    }
    
    @DELETE
    @Path("/{index:[0-9]+}")
    public void deletePolozka(@PathParam("index") int index) {
        if(menu.containsKey(index))
            menu.remove(index);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getPonuka() {
        String all="";
        for(Entry<Integer,Jedlo> entry:menu.entrySet())
            all=all+entry.getValue()+"";
        return all;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public int postJedlo(Jedlo content){
        int index=1;
    
        while(menu.containsKey(index))
        {
            index++;
        }
        menu.put(index, content);
        return index;
    }
}
