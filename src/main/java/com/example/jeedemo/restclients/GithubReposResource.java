package com.example.jeedemo.restclients;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("github")
public class GithubReposResource {

	@Inject
	private GithubReposService service;

	@GET
	@Path("{username}")
	public List<Repo> listRepos(@PathParam("username") final String username) {
		return service.listRepos(username);
	}
}
