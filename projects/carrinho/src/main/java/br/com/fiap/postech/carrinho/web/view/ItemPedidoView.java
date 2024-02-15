package br.com.fiap.postech.carrinho.web.view;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemPedido;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedidoView(
        UUID id,
        Integer quantidade,
        String nome,
        BigDecimal valorUnitario
) {
    public ItemPedidoView(ItemPedido i) {
        this(
                i.getIdItem(),
                i.getQuantidade(),
                i.getNome(),
                i.getValorUnitario()
        );
    }
}
