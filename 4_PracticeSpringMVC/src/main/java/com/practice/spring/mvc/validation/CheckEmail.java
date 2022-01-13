package com.practice.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//К чему будет применяться аннотация поле/метод/класс, в данном случае к полю
@Retention(RetentionPolicy.RUNTIME)//
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {
    String value() default "xyz.com";

    String message() default "email mast ends with xyz.com";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
