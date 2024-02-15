package br.com.fiap.postech.autenticacao.dominio.repositorio;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;

import java.util.Optional;
import java.util.UUID;

public interface ContatoRepository {
    Contato criaOuAtualiza(Contato contato);
    Optional<Contato> buscaPorId(UUID id);
    Optional<Contato> buscaPorIdUsuario(UUID idUsuario);
}