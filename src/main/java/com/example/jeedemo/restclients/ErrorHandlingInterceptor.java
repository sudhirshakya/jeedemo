package com.example.jeedemo.restclients;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ErrorHandler
@Interceptor
public class ErrorHandlingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingInterceptor.class);

    @AroundInvoke
    public Object handleException(final InvocationContext ctx) {
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            logger.warn("There was an exception with message [{}].", ex.getMessage());
            return null;
        }
    }

}
