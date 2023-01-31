package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import io.quarkus.cache.CacheResult;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Path("/hello")
public class GreetingResource {

    @Inject
    Event<GreetingEvent> greetingEvent;

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