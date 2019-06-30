package com.example.jeedemo.xmlclient;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class XmlClientService {

	@Inject
	@LegacyService
	private WebTarget jaxrsClient;

	public String fetch() {
		Object object = new Object();
		jaxrsClient.path("resource")
			.request()
			.post(Entity.xml(object));
		return "done";
	}
}
