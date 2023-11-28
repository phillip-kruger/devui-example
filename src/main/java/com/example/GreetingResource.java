package com.example;

import com.example.resetclient.Country;
import com.example.resetclient.CountryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.Set;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@GraphQLApi
@Path("/hello")
public class GreetingResource {

    @Inject
    Event<GreetingEvent> greetingEvent;

    @RestClient
    CountryService countryService;
    
    @ConfigProperty(name = "greeting.message") 
    String message;
    
    @Query
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @CacheResult(cacheName = "hello-cache")
    public String hello(@PathParam("name") String name) {
        String m = message + " " + name;
        greetingEvent.fire(new GreetingEvent(m));
        return m;
    }
    
    @Query
    public Set<Country> getCountries(){
        return countryService.getCountries();
    }
}
