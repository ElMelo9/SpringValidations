package com.SpringValidations.advice.validation.validator;

import com.SpringValidations.advice.validation.anotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName,String> {

    @Override
    public void initialize(ValidName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        // Add your validation logic here
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        // Additional checks, e.g., regex pattern match
        return true;

    }
}
