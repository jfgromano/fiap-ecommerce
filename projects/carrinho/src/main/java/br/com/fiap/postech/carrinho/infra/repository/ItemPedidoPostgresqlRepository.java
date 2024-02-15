package br.com.fiap.postech.carrinho.infra.repository;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemPedido;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemPedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ItemPedidoPostgresqlRepository extends JpaRepository<ItemPedido, UUID>, ItemPedidoRepository {
    @Transactional
    default void salvarItens(List<ItemPedido> itens) {
        this.saveAll(itens);
    }
}
