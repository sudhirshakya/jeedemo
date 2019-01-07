package com.example.jeedemo.restclients;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaxRsClientRequestFilter implements ClientRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JaxRsClientRequestFilter.class);

    protected static final String TIME_BEFORE = "time.before";

    @Override
    public final void filter(final ClientRequestContext requestContext) throws IOException {
        logger.debug("Making REST call to [{}].", requestContext.getUri());

        requestContext.getHeaders().add("Accept", "application/vnd.github.v3+json");
        requestContext.setProperty(TIME_BEFORE, System.currentTimeMillis());
    }

}
