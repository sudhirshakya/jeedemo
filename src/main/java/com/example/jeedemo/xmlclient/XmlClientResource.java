package com.example.jeedemo.xmlclient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("xmldemo")
public class XmlClientResource {

	@Inject
	private XmlClientService service;

	@GET
	public String fetch() {
		return service.fetch();
	}
}
