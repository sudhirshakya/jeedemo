package com.example.jeedemo.cdievents;

import lombok.Data;

@Data
public class ExampleEvent {

    private String name;

    public ExampleEvent(final String name) {
        this.name = name;
    }
}

