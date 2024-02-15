package br.com.fiap.postech.carrinho.dominio.gateway;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;

public interface ItemGateway {
    void atualizarDadosItem(String token, ItemCarrinho item);
}
