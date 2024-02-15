package br.com.fiap.postech.gestaoitens.dominio.repositorio;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepository {
    Item criaOuAtualiza(Item item);
    Optional<Item> buscaPorId(UUID id);
    Optional<Item> buscaPorIdParaAtualizar(UUID id);
    List<Item> listarTodos(int pagina, int limit);
    long count();

}