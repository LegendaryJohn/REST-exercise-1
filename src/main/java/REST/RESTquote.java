/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kann
 */
@Path("quote")
public class RESTquote {

    private static Map<Integer, String> quotes = new HashMap()
    {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }

    };
    @Context
    private UriInfo context;
   
    /**
     * Creates a new instance of RESTperson
     */
    public RESTquote(){

    }
    
    /**
     * Retrieves representation of an instance of com.mycompany.resttesting.RESTperson
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) {
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(id));
        return new Gson().toJson(quote);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getQuotes() {
        return new Gson().toJson(quotes);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postQuote(String content) 
    {
        
        JsonObject newQuote = new JsonParser().parse(content).getAsJsonObject();
        String quote = newQuote.get("quote").getAsString();
        quotes.put(quotes.size()+1, quote);
        return "{\"Success\":true}";
    }
    
    /**
     * PUT method for updating or creating an instance of RESTperson
     * @param id
     * @param content
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void putQuote(@PathParam("id") int id, String content) {
        System.out.println("putQuote");

        System.out.println(content);
        JsonObject jo = new JsonParser().parse(content).getAsJsonObject();
        String quote = jo.get("quote").getAsString();
        quotes.replace(1, quote);
    
    }
    
    @DELETE
    @Path("{id}")
    public void delQuote(@PathParam("id") int id) {
        quotes.remove(id);
    }
}
