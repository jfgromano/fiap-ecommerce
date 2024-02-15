package br.com.fiap.postech.carrinho.dominio.repositorio;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;

import java.util.List;
import java.util.UUID;

public interface ItemCarrinhoRepository {
    void adicionarItem(UUID itemUUID, UUID usuarioUUID, int quantidade);
    void removerItem(UUID itemUUID, UUID usuarioUUID, int quantidade);
    List<ItemCarrinho> buscarItensDoCarrinho(UUID idUsuario);
}