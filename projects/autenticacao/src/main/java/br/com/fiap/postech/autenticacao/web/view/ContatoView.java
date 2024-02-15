package br.com.fiap.postech.autenticacao.web.view;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;

import java.util.UUID;

public record ContatoView(
        UUID id,
        String email,
        String numeroCelular
){
    public ContatoView(Contato c) {
        this(
                c.getId(),
                c.getEmail(),
                c.getNumeroCelular()
        );
    }
}
