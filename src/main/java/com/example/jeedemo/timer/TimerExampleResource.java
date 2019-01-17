package com.example.jeedemo.timer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("timers")
@Stateless
public class TimerExampleResource {

	@Resource
	private TimerService timer;
	
	@GET
	@Path("{name}")
	public void printDelayed(@PathParam("name") String name) {
		timer.createTimer(5000, "Got name: " + name);
	}
	
	@Timeout
	public void print(Timer timer) {
		String string = (String) timer.getInfo();
		System.out.println(string);
	}
}
