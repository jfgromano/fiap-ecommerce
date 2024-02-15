package br.com.fiap.postech.autenticacao.web.validacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullOrNotBlankValidador implements ConstraintValidator<NullOrNotBlank, String> {
    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        if(valor == null){
            return true;
        }
        return !valor.trim().isEmpty();
    }
}
