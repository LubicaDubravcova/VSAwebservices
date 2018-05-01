/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

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
@Path("udalost")
@Singleton
public class UdalostResource {

    @Context
    private UriInfo context;
    private List<String> udalost;
    private String popis;
    /**
     * Creates a new instance of UdalostResource
     */
    public UdalostResource() {
        udalost=new ArrayList<>();
        udalost.add("prvykomentar");
        udalost.add("druhykomentar");
        popis="tato udalost je...";
    }

  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getPocet() {
        return udalost.size();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void postKomentar(String content) {
        udalost.add(content);
    }
    
    @GET
    @Path("/{no}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getKomentar(@PathParam("no") int index) {
        if (index>0 && index<=udalost.size())
            return udalost.get(index-1);
        else
            return "NIC";
    }
    
    @DELETE
    @Path("{no:[0-9]+}")
    public void deleteKomentar(@PathParam("no") int index) {
        if (index>0 && index<=udalost.size())
            udalost.remove(index-1);
    }
    
    
    @GET
    @Path("/popis")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPopis() {
        return popis;
    }
    
    @PUT
    @Path("/popis")
    @Consumes(MediaType.TEXT_PLAIN)
    public void putPopis(String content) {
        popis=content;      
    }
}
