package com.productapp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//1. custom annotation
@Documented
@Constraint(validatedBy = { ProductValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ValidateProductType {
    String message() default "Invalid product type :EL or BOOK FMCG";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
