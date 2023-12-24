package com.example.thymeleafmvcrest.customannotationforvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class EmailValidationConstraintValidator implements ConstraintValidator<EmailValidation, String> {

    private String emailPrefix;

    @Override
    public void initialize(EmailValidation emailValidation) {
        emailPrefix = emailValidation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (theCode != null) result = theCode.endsWith(emailPrefix);
        else return true;

        return result;
    }

}
