package com.example.jeedemo.restclients;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;

public class GithubReposService {

    private static final GenericType<List<Repo>> REPOS_TYPE = new GenericType<List<Repo>>() {};

    @Inject
    @Github
    private Client client;

    @ErrorHandler
    public List<Repo> listRepos(final String username) {
        return client.target("https://api.github.com/users").path(username).path("repos").request().get(REPOS_TYPE);
    }
}
