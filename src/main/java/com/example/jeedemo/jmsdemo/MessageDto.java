package com.example.jeedemo.jmsdemo;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MessageDto implements Serializable {

    private static final long serialVersionUID = -1019990830434118028L;

    private String url;
    private String payload;

    public MessageDto() {
    }

    public MessageDto(final String url, final String payload) {
        this.url = url;
        this.payload = payload;
    }
}
