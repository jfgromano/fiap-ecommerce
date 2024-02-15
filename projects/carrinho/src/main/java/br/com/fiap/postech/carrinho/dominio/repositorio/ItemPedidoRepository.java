package br.com.fiap.postech.carrinho.dominio.repositorio;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemPedido;

import java.util.List;

public interface ItemPedidoRepository {
    void salvarItens(List<ItemPedido> itens);
}