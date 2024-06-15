package com.SpringValidations.advice.validation.anotation;

import com.SpringValidations.advice.validation.validator.ValidNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
/*
    Forma de crear propias validaciones con anotaciones
*/
@Documented
@Constraint(validatedBy = ValidNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface ValidName {

    String message() default "{custom.validation.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
