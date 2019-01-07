package com.example.jeedemo.cdievents;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class TriggerService {

    @Inject
    private Event<ExampleEvent> event;

    public final String triggerEvent(final String name) {
        try {
            ExampleEvent payload = new ExampleEvent(name);
            event.fire(payload);
            return "Successfully handled";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
