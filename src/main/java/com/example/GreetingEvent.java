package com.example;

import java.time.LocalDateTime;

public class GreetingEvent {
    public String message;
    public LocalDateTime time;

    public GreetingEvent(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{ time=" + time + ", message=" + message + "}";
    }
    
}
