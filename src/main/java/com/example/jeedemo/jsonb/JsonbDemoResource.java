package com.example.jeedemo.jsonb;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("jsonb")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JsonbDemoResource {

	private static final Logger logger = LoggerFactory.getLogger(JsonbDemoResource.class);

	@POST
	public void foo() {
		String jsonString = "{\"name\": \"John Doe\", \"age\": 30}";
		logger.info(jsonString);
		Jsonb jsonb = JsonbBuilder.create();
		DemoDto dto = jsonb.fromJson(jsonString, DemoDto.class);
		logger.info("After deserialization: {}.", dto);
	}

}
