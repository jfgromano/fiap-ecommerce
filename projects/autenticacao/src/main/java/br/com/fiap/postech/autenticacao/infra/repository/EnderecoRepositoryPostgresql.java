package br.com.fiap.postech.autenticacao.infra.repository;

import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.EnderecoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepositoryPostgresql extends JpaRepository<Endereco, UUID>, EnderecoRepository {

    default Endereco criaOuAtualiza(Endereco endereco) {
        return save(endereco);
    }

    default Optional<Endereco> buscaPorId(UUID id) {
        return findById(id);
    }

    default Optional<Endereco> buscaPorIdUsuario(UUID id) {
        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        endereco.setUsuario(usuario);
        return findOne(Example.of(endereco));
    }
}
