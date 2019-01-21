package com.example.jeedemo.restclients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class PostDemoService {

	public String fetch() {
		WebTarget target = this.clientProducer();
		PersonalInfo info = new PersonalInfo("John Doe", "john@example.com", 50);

		Response response = target.request().post(Entity.json(info));
		return response.getStatus() + " " + response.getStatusInfo().getReasonPhrase();
	}

	private WebTarget clientProducer() {
		Client client = ClientBuilder.newBuilder().build();
		return client.register(HmacHeaderInterceptor.class).target("http://localhost:8080/jeedemo/api/post-demo");
	}
}
