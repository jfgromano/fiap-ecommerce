package br.com.fiap.postech.pagamento.web.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NumberValidador.class)
public @interface Number {
    boolean required() default true;
    String message() default "se informado, deve ser um numero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}