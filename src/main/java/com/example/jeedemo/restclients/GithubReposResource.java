package com.example.jeedemo.restclients;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("github")
public class GithubReposResource {

    @Inject
    private GithubReposService service;

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Repo> listRepos(@PathParam("username") final String username) {
        return service.listRepos(username);
    }
}
