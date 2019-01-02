package com.example.jeedemo.restclients;

import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class JaxRsClientProducer {

	@Produces
	@Github
	public Client clientProducer() {
		Client client = ClientBuilder.newClient();
		client = client.register(JaxRsClientRequestFilter.class).register(JaxRsClientResponseFilter.class);

		return client;
	}
}
