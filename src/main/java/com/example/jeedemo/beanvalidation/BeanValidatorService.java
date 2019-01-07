package com.example.jeedemo.beanvalidation;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

public class BeanValidatorService {

    @Inject
    private Validator validator;

    public void validate(DemoBean bean) {
        Set<ConstraintViolation<DemoBean>> violations = validator.validate(bean);
        violations.stream().map(v -> v.getPropertyPath() + " has error " + v.getMessage()).forEach(System.out::println);
    }
}
