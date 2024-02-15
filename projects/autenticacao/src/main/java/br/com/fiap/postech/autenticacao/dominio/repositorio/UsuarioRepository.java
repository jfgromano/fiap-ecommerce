package br.com.fiap.postech.autenticacao.dominio.repositorio;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario cria(Usuario usuario);
    Optional<Usuario> buscaPorEmailSenha(String nome, String email);
    Optional<Usuario> buscaPorEmail(String email);
}