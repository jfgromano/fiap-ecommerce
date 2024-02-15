package br.com.fiap.postech.carrinho.web.view;

import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;
import br.com.fiap.postech.carrinho.dominio.enums.StatusPedido;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record PedidoView(
        UUID id,
        StatusPedido status,
        List<ItemPedidoView> itens
) {
    public static PedidoView fromPedido(Pedido pedido) {
        return  new PedidoView(
                pedido.getId(),
                pedido.getStatus(),
                pedido.getItensPedido().stream().map(i -> new ItemPedidoView(i)).collect(Collectors.toList())
        );
    }
}
