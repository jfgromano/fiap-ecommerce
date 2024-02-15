package br.com.fiap.postech.pagamento.dominio.dto;

public record FalhaPedidoDto(
        String tipo,
        PedidoDto pedido
) {
    public static FalhaPedidoDto pagamento(PedidoDto pedido) {
        return new FalhaPedidoDto("ERRO_PAGAMENTO", pedido);
    }
}