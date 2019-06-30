package com.example.jeedemo.xmlclient;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class JaxRsClientProducer {

    private static final int CONNECTION_TIMEOUT = 500;

    private static final int READ_TIMEOUT = 2000;

    @Produces
    @LegacyService
    public final WebTarget clientProducer() {
        Client client = ClientBuilder.newBuilder()
        		.connectTimeout(CONNECTION_TIMEOUT, MILLISECONDS)
                .readTimeout(READ_TIMEOUT, MILLISECONDS)
                .build();
        client = client.register(JaxRsClientRequestFilter.class).register(JaxRsClientResponseFilter.class);
        
        return client.target("http://www.example.com/xmlresource");
    }
}
