/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
    private Map<String,String> slovo;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        slovo = new HashMap<>();
        slovo.put("flower", "kvet");
        slovo.put("dog", "pes");
    }

    
    @GET
    @Path("/{slovo:[a-z]+}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("slovo")String key) {
        return slovo.get(key);
    }

    @PUT
    @Path("{slovo:[a-z]+}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(@PathParam("slovo")String key,String content) {
        slovo.put(content, key);
    }
    
    @DELETE
    @Path("{slovo:[a-z]+}")
    public void deleteText(@PathParam("slovo")String key) {
        slovo.remove(key);
    }
}
