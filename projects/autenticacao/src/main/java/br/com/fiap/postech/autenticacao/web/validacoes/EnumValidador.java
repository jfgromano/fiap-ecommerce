package br.com.fiap.postech.autenticacao.web.validacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidador implements ConstraintValidator<EnumValida, String>  {
    private EnumValida annotation;

    @Override
    public void initialize(EnumValida constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        for (Object enumValue : enumValues) {
            if (enumValue.toString().equals(value.toString())) {
                return true;
            }
        }
        return false;
    }
}
