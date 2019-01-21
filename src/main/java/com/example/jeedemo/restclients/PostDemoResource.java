package com.example.jeedemo.restclients;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("post-demo")
public class PostDemoResource {

	@Inject
	private PostDemoService service;

	@GET
	public String fetch() {
		return service.fetch();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void printPost(@Context HttpHeaders headers, PersonalInfo info) {
		headers.getRequestHeaders().entrySet().stream().forEach(this::print);
		System.out.println("Uploaded object: " + info);
	}

	private void print(Map.Entry<String, List<String>> header) {
		String value = header.getValue().stream().collect(Collectors.joining(", "));
		System.out.println(header.getKey() + ": " + value);
	}
}
