package br.com.fiap.postech.autenticacao.web.form;

import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;
import br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects.Estado;
import br.com.fiap.postech.autenticacao.web.validacoes.EstadoEnderecoValido;
import br.com.fiap.postech.autenticacao.web.validacoes.NullOrNotBlank;
import br.com.fiap.postech.autenticacao.web.validacoes.Number;
import jakarta.validation.constraints.NotBlank;

public record EnderecoForm(
        @NotBlank
        String rua,
        @Number(required = false)
        String numero,
        @NullOrNotBlank
        String bairro,
        @NotBlank
        String cidade,
        @EstadoEnderecoValido
        String estado) {
    public Endereco asEndereco() {
        return new Endereco(
                this.rua,
                this.numero,
                this.bairro,
                this.cidade,
                Estado.buscarPorSigla(this.estado)
        );
    }
}