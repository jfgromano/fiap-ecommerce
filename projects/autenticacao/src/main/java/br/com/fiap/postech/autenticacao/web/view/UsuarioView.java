package br.com.fiap.postech.autenticacao.web.view;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;

import java.util.UUID;

public record UsuarioView(
        UUID id,
        String email,
        String nome,
        String sexo,
        String cpf,
        String dataDeNascimento,
        Boolean admin
) {
    public UsuarioView(Usuario u) {
        this(
            u.getId(),
            u.getEmail(),
            u.getNome(),
            u.getSexo().getSigla(),
            u.getCpf(),
            u.getDataDeNascimentoString(),
            u.getAdmin()
        );
    }
}
