/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class NewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Uloha5/webresources";

    public NewJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public void deleteJedlo(String den, String index) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{den, index})).request().delete();
    }

    public String getJedlo(String den, String index) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{den, index}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String getPocet(String den) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{den}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void postJedlo(Object requestEntity, String den) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{den})).request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public void putJedlo(Object requestEntity, String den, String index) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{den, index})).request(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN));
    }

    public void close() {
        client.close();
    }
    
}
