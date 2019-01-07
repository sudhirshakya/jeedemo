package com.example.jeedemo.restclients;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class Repo {

    private String name;

    @JsonbProperty("html_url")
    private String htmlUrl;
}
