package br.com.fiap.postech.carrinho.web.form;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.web.validacoes.Number;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ItemForm(
        @NotNull
        @Number(message = "deve ser um numero")
        String quantidade
) {
    public ItemCarrinho asItem(UUID idItem, UUID idUsuario) {
        return new ItemCarrinho(
                idUsuario,
                idItem,
                Integer.valueOf(this.quantidade)
        );
    }
}