package com.productapp.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductValidator implements ConstraintValidator<ValidateProductType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //logic
        List<String> productType= Arrays.asList("EL","BOOK");
        return productType.contains(value);
    }
}
