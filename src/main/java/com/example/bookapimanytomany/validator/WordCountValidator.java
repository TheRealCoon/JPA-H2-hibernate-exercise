package com.example.bookapimanytomany.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WordCountValidator implements ConstraintValidator<NoSingleWordValidator, String> {

    @Override
    public void initialize(NoSingleWordValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.split(" ").length >= 2;
    }
}
