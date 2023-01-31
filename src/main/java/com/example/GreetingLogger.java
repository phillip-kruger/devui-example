package com.example;

import io.quarkus.logging.Log;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class GreetingLogger {

    public void log(@Observes GreetingEvent event) {
        Log.info(event.time + " | " + event.message);
    }
}