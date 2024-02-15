package br.com.fiap.postech.carrinho.infra.repository;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemCarrinhoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface ItemCarrinhoPostgresqlRepository extends JpaRepository<ItemCarrinho, UUID>, ItemCarrinhoRepository {

    @Transactional
    default void adicionarItem(UUID itemUUID, UUID usuarioUUID, int quantidade) {
        List<ItemCarrinho> itens = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            ItemCarrinho item = new ItemCarrinho(usuarioUUID, itemUUID, 1);
            itens.add(item);
        }
        this.saveAll(itens);
    }

    @Transactional
    default void removerItem(UUID itemUUID, UUID usuarioUUID, int quantidade) {
        Page<ItemCarrinho> itens = buscarItensDoCarrinhoPorIdItem(usuarioUUID, itemUUID, PageRequest.of(0, quantidade));
        List<UUID> ids = new ArrayList<>();
        itens.forEach(i -> ids.add(i.getId()));
        this.deleteAllById(ids);
    }

    default Page<ItemCarrinho> buscarItensDoCarrinhoPorIdItem(UUID idUsuario, UUID idItem, Pageable pageable) {
        ItemCarrinho example = new ItemCarrinho();
        example.setIdItem(idItem);
        example.setIdUsuario(idUsuario);
        return this.findAll(Example.of(example), pageable);
    }

    default List<ItemCarrinho> buscarItensDoCarrinho(UUID idUsuario) {
        ItemCarrinho example = new ItemCarrinho();
        example.setIdUsuario(idUsuario);
        Map<UUID, ItemCarrinho> itensAgrupados = new HashMap<>();
        List<ItemCarrinho> itensInidividuais = this.findAll(Example.of(example));
        for (ItemCarrinho i : itensInidividuais) {
            if(!itensAgrupados.containsKey(i.getIdItem())) {
                i.setQuantidade(0);
                itensAgrupados.put(i.getIdItem(), i);
            }
            itensAgrupados.get(i.getIdItem()).aumentarQuantidade(1);
        }
        return new ArrayList<>(itensAgrupados.values());
    }
}
