package br.com.fiap.postech.autenticacao.infra.repository;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.ContatoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContatoRepositoryPostgresql extends JpaRepository<Contato, UUID>, ContatoRepository {

    default Contato criaOuAtualiza(Contato contato) {
        return save(contato);
    }

    default Optional<Contato> buscaPorId(UUID id) {
        return findById(id);
    }

    default Optional<Contato> buscaPorIdUsuario(UUID id) {
        Contato contato = new Contato();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        contato.setUsuario(usuario);
        return findOne(Example.of(contato));
    }
}
