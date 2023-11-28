package com.example.log;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.logging.Logger;

/**
 * Generating some log lines
 * @author Phillip Kruger (phillip.kruger@redhat.com)
 */
@ApplicationScoped
public class LogCreator {
    private static final Logger LOG = Logger.getLogger(LogCreator.class);
    
    private final AtomicInteger infoCounter = new AtomicInteger();
    private final AtomicInteger warnCounter = new AtomicInteger();
    private final AtomicInteger errorCounter = new AtomicInteger();
    private final AtomicInteger debugCounter = new AtomicInteger();
    private final AtomicInteger traceCounter = new AtomicInteger();
    
    @Scheduled(every="60s")
    void logInfo() {
        LOG.info("Information message (" + infoCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="61s")
    void logWarn() {
        LOG.warn("Warning message (" + warnCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="62s")
    void logError() {
        LOG.error("Error message (" + errorCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="63s")
    void debugError() {
        LOG.debug("Debug message (" + debugCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="64s")
    void traceError() {
        LOG.trace("Trace message (" + traceCounter.incrementAndGet() + ")");
    }
    
    @Scheduled(every="300s")
    void logException(){
        throw new IllegalStateException("This is a random exception " + LocalDateTime.now());
    }
    
}
