package br.com.fiap.postech.gestaoitens.dominio.dto;

import java.util.Map;
import java.util.UUID;

public record FalhaPedidoDto(
        String tipo,
        PedidoDto pedido,
        Map<UUID, Integer> quantidadeDisponivelPorProduto
) {
    public static FalhaPedidoDto estoque(PedidoDto pedido, Map<UUID, Integer> quantidadeDisponivelPorProduto) {
        return new FalhaPedidoDto("ERRO_ESTOQUE", pedido, quantidadeDisponivelPorProduto);
    }
}
