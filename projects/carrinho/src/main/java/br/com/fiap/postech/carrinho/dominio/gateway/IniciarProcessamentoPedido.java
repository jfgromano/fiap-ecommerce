package br.com.fiap.postech.carrinho.dominio.gateway;

import br.com.fiap.postech.carrinho.dominio.dto.PedidoDto;

public interface IniciarProcessamentoPedido {
    void executa(PedidoDto pedidoDto);
}