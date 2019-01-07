package com.example.jeedemo.cdievents;

import javax.enterprise.event.Observes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(EventHandler.class);

    public final void onNameEvent(@Observes final ExampleEvent event) {
        logger.info("Handling message for '{}'.", event.getName());
        if (event.getName().startsWith("e")) {
            throw new RuntimeException("We cannot handle names starting with e.");
        }
    }
}
