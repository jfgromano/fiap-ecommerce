package br.com.fiap.postech.autenticacao.web.view;

import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;

import java.util.UUID;

public record EnderecoView(
        UUID id,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String estado
){
    public EnderecoView(Endereco e) {
        this(
                e.getId(),
                e.getRua(),
                e.getNumero(),
                e.getBairro(),
                e.getCidade(),
                e.getEstado().getSigla()
        );
    }
}