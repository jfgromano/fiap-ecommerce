package br.com.fiap.postech.gestaoitens.dominio.dto;

import java.util.UUID;

public record ItensDoPedidoDto(
        UUID itemId,
        int quantidade
) {
}
