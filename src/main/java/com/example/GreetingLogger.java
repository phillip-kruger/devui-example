package com.example;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class GreetingLogger {

    public void log(@Observes GreetingEvent event) {
        Log.info(event.time + " | " + event.message);
    }
}