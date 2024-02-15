package br.com.fiap.postech.autenticacao.dominio.repositorio;

import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;

import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository {
    Endereco criaOuAtualiza(Endereco endereco);
    Optional<Endereco> buscaPorId(UUID id);
    Optional<Endereco> buscaPorIdUsuario(UUID idUsuario);
}
