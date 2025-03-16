package by.epam.ch1.validator.notnulllong;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullValidator implements ConstraintValidator<NottNullLong, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null;
    }
}