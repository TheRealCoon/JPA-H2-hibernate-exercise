package com.example.bookapimanytomany.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WordCountValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSingleWordValidator {
    String message() default "Invalid title length!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

