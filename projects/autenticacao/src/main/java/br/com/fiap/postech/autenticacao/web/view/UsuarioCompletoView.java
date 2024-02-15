package br.com.fiap.postech.autenticacao.web.view;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;

public record UsuarioCompletoView(
        UsuarioView usuario,
        EnderecoView endereco,
        ContatoView contato
) {
    public UsuarioCompletoView(Usuario u) {
        this(
            new UsuarioView(u),
            new EnderecoView(u.getEndereco()),
            new ContatoView(u.getContato())
        );
    }
}
