package br.com.fiap.postech.carrinho.web.view;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;

import java.util.List;
import java.util.stream.Collectors;

public record CarrinhoView(
        List<ItemCarrinhoView> itens
) {
    public static CarrinhoView fromItensCarrinho(List<ItemCarrinho> itens) {
        List<ItemCarrinhoView> novaLista = itens.stream().map(i -> new ItemCarrinhoView(i)).collect(Collectors.toList());
        return new CarrinhoView(novaLista);
    }
}
