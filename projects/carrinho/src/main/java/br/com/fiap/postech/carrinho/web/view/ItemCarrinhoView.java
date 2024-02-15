package br.com.fiap.postech.carrinho.web.view;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemCarrinhoView(
        UUID id,
        Integer quantidade,
        String nome,
        BigDecimal valorUnitario
) {
    public ItemCarrinhoView(ItemCarrinho i) {
        this(
                i.getIdItem(),
                i.getQuantidade(),
                i.getNome(),
                i.getValorUnitario()
        );
    }
}
