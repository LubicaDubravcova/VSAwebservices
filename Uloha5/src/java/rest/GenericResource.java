/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
    private Map<String,Map<Integer,String>> menu;
        /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        menu=new HashMap<>();      
        menu.put("Pon",new HashMap());
        menu.get("Pon").put(1,"zmrzlina");
        menu.get("Pon").put(2,"Kung Pao");
        
        menu.put("Str", new HashMap());
        menu.get("Str").put(1,"gulas");
        menu.get("Str").put(2,"mouse");
    }

    @GET
    @Path("/{den:[A-Z].*}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPocet(@PathParam("den") String key) {
        if(menu.get(key)!=null){
            return ""+menu.get(key).size();
        }
        else
            return "0";
    }
    
    @POST
    @Path("/{den:[A-Z].*}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void postJedlo(@PathParam("den") String key,String content) {
        int cislo=1;
        while (menu.get(key).get(cislo)!=null)
            cislo++;
        menu.get(key).put(cislo,content);
       
    }
    
    @GET
    @Path("/{den:[A-Z].*}/{index:[0-9]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJedlo(@PathParam("den") String key, @PathParam("index") int index) {
       
        if(index>0 && menu.get(key).get(index)!=null )
            return menu.get(key).get(index);
        else
            return "nemame";
    }
    
    @PUT
    @Path("/{den:[A-Z].*}/{index:[0-9]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putJedlo(@PathParam("den") String key,@PathParam("index") int index,String content) {
        if(index>0 && menu.get(key).get(index)!=null )
            menu.get(key).put(index, content);
    }
    
    @DELETE
    @Path("/{den:[A-Z].*}/{index:[0-9]+}")
    public void deleteJedlo(@PathParam("index") int index,@PathParam("den") String key) {
        Map<Integer,String> den;
        den=menu.get(key);
        if(den!=null)
            den.remove(index);
    }
}
