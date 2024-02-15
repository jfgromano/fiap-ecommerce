package br.com.fiap.postech.carrinho.infra.repository;

import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;
import br.com.fiap.postech.carrinho.dominio.repositorio.PedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoPostgresqlRepository extends JpaRepository<Pedido, UUID>, PedidoRepository {
    @Transactional
    default Pedido salvarAtualizar(Pedido pedido) {
        return this.save(pedido);
    }

    default Optional<Pedido> buscarPorId (UUID id) {
        return this.findById(id);
    }
}
