package com.example.thymeleafmvcrest.customannotationforvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidationConstraintValidator.class)
public @interface EmailValidation {

    public String value() default "@gmail.com";

    public String message() default "Invalid Email: must be end with @gmail.com";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
