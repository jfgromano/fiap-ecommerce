package br.com.fiap.postech.gestaoitens.web.validacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberValidador implements ConstraintValidator<Number, String> {
    private boolean required;

    @Override
    public void initialize(Number annotation) {
        this.required = annotation.required();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        if(valor == null && this.required){
            return false;
        }else if(valor == null && !this.required){
            return true;
        }

        return valor.trim().matches("^[0-9]+$");
    }
}