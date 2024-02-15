package br.com.fiap.postech.autenticacao.web.validacoes;

import br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects.Estado;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EstadoEnderecoValidador implements ConstraintValidator<EstadoEnderecoValido, String>  {
    @Override
    public boolean isValid(String uf, ConstraintValidatorContext constraintValidatorContext) {
        return Estado.buscarPorSigla(uf) != null;
    }
}
