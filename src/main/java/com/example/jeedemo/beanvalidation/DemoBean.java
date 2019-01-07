package com.example.jeedemo.beanvalidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class DemoBean {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Max(100)
    @Min(0)
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "\\d{10}")
    private String phoneNumber;
}
