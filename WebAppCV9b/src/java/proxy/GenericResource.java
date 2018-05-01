/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.ArrayList;
import java.util.List;
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
    //private Map<String,String> slova;
    
    private List<String> menu;
    
    
    

    /**
     * inicializuje menu s tromi polozkami
     */
    public GenericResource() {
       menu = new ArrayList<>(); 
       menu.add("Halusky");
       menu.add("Rezen");
       menu.add("Gulas");
           
    }
    
    
    /**
     * vrati textovu reprezentaciu celeho menu
     */
   @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        String all = "";
        for (String s: menu)
            all = all + s + "\n";
        return all;
    }
    

    /**
     * vrati konkretnu polozku menu
     */
    @GET
    @Path("{index: [0-9]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMenu(@PathParam("index") int x ) {
        if (x<menu.size())
            return menu.get(x);
        else
            return "nemame";
    }

    /**
     * modifikuje existujucu polozku v menu
     */
    @PUT
    @Path("{index: [0-9]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putMenu(@PathParam("index") int x, String content) {
        if (x<menu.size())
            menu.set(x, content);
       
    }
    
    /**
     * prida novu polozku do menu
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void postMenu(String content) {
           menu.add(content);         
    }
    
    @DELETE
    //@Consumes(MediaType.TEXT_PLAIN)
    @Path("{index: [0-9]+}")
    public void deleteMenu(@PathParam("index") int x) {
        if (x<menu.size())
            menu.remove(x);
    }
}

