package com.example.jeedemo.beanvalidation;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("beans")
public class BeanResource {

    @Inject
    private BeanValidatorService service;

    @POST
    public void validate(DemoBean bean) {
        service.validate(bean);
    }
}
