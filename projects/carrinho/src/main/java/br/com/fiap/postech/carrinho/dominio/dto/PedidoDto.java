package br.com.fiap.postech.carrinho.dominio.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record PedidoDto(
        UUID idPedido,
        UUID idCartao,
        BigDecimal valorTotal,
        List<ItensDoPedidoDto> itens
) {
}
