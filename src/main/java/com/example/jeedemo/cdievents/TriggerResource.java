package com.example.jeedemo.cdievents;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("events")
public class TriggerResource {

    @Inject
    private TriggerService service;

    @GET
    @Path("{name}")
    public final String triggerEvent(@PathParam("name") final String name) {
        return service.triggerEvent(name);
    }
}
