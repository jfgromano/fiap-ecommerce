package br.com.fiap.postech.carrinho.dominio.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record FalhaPedidoDto(
        String tipo,
        PedidoDto pedido,
        Map<UUID, Integer> quantidadeDisponivelPorProduto
) {
    public FalhaPedidoDto(String tipo, PedidoDto pedido) {
        this(tipo, pedido, new HashMap<>());
    }
}
