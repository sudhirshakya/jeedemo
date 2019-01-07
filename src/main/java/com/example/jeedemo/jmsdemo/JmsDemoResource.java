package com.example.jeedemo.jmsdemo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("messages")
public class JmsDemoResource {

    @Inject
    private MessageDeliveryService service;

    @GET
    @Path("{name}")
    public final void handleEvent(@PathParam("name") final String name) {
        service.handleEvent(name);
    }
}
