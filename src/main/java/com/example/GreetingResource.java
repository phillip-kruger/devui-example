package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@Path("/hello")
public class GreetingResource {

    @Inject
    Event<GreetingEvent> greetingEvent;

    @Query
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @CacheResult(cacheName = "hello-cache")
    public String hello(@PathParam("name") String name) {
        String message = "Hello " + name;
        greetingEvent.fire(new GreetingEvent(message));
        return message;
    }
}
