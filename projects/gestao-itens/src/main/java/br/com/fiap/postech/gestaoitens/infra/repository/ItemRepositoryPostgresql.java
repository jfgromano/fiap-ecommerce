package br.com.fiap.postech.gestaoitens.infra.repository;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepositoryPostgresql extends JpaRepository<Item, UUID>, ItemRepository {

    default Item criaOuAtualiza(Item item) {
        return save(item);
    }

    default Optional<Item> buscaPorId(UUID id) {
        return findById(id);
    }

    @Lock(LockModeType.PESSIMISTIC_READ)
    default Optional<Item> buscaPorIdParaAtualizar(UUID id) {
        return findById(id);
    }

    default List<Item> listarTodos(int pagina, int limit) {
        PageRequest pageable = PageRequest.of(pagina, limit);
        Page<Item> page = findAll(pageable);
        return page.toList();
    }
    default void remover(Item item) {
        delete(item);
    }
}
