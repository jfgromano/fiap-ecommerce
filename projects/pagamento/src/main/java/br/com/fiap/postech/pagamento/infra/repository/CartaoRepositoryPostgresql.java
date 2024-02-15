package br.com.fiap.postech.pagamento.infra.repository;

import br.com.fiap.postech.pagamento.dominio.entidade.Cartao;
import br.com.fiap.postech.pagamento.dominio.repositorio.CartaoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepositoryPostgresql extends JpaRepository<Cartao, UUID>, CartaoRepository {
    default Cartao salvar(Cartao cartao) {
        return save(cartao);
    }
    default Optional<Cartao> buscarPorId(UUID id) {
        return findById(id);
    }

    default Optional<Cartao> buscarPorToken(String token) {
        Cartao cartao = new Cartao();
        cartao.setToken(token);
        return this.findOne(Example.of(cartao));
    }
}
