package com.example.jeedemo.restclients;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class JaxRsClientProducer {

    @Produces
    @Github
    public Client clientProducer() {
        Client client = ClientBuilder.newBuilder().connectTimeout(500, MILLISECONDS).readTimeout(2000, MILLISECONDS)
                .build();
        client = client.register(JaxRsClientRequestFilter.class).register(JaxRsClientResponseFilter.class);

        return client;
    }
}
