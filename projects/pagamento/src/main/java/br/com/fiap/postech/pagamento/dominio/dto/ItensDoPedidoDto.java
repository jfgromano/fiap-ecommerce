package br.com.fiap.postech.pagamento.dominio.dto;

import java.util.UUID;

public record ItensDoPedidoDto(
        UUID itemId,
        int quantidade
) {
}
