package br.com.fiap.postech.carrinho.dominio.dto;

import java.util.UUID;

public record ItensDoPedidoDto(
        UUID itemId,
        int quantidade
) {
}
