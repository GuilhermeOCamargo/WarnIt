package br.com.warnit.validators.annotations;

import br.com.warnit.validators.impl.EmailUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
public @interface EmailUniqueValid {
    String message()default "E-mail já Cadastrado.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
    String email() default "";
    String id() default "";
}
