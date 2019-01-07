package com.example.jeedemo.restclients;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaxRsClientResponseFilter implements ClientResponseFilter {

    private static final Logger logger = LoggerFactory.getLogger(JaxRsClientResponseFilter.class);

    @Override
    public final void filter(final ClientRequestContext requestContext, final ClientResponseContext responseContext)
            throws IOException {
        long after = System.currentTimeMillis();
        Long before = (Long) requestContext.getProperty(JaxRsClientRequestFilter.TIME_BEFORE);

        logger.info("Call to [{}] took {} milliseconds.", requestContext.getUri(), after - before);
    }

}
