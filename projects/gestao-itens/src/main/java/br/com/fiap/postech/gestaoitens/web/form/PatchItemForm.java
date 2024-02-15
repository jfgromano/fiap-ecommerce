package br.com.fiap.postech.gestaoitens.web.form;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.web.validacoes.Number;

import java.math.BigDecimal;
import java.util.UUID;

public record PatchItemForm(
    @Number(required = false)
    String quantidade,

    @Number(required = false)
    String valor
) {
    public Item asItem() {
        Integer quantidade = null;
        if(this.quantidade != null) {
            quantidade = Integer.valueOf(this.quantidade);
        }

        BigDecimal valor = null;
        if(this.valor != null) {
            valor = new BigDecimal(this.valor);
        }

        return new Item(
                null,
                null,
                quantidade,
                valor
        );
    }

    public Item asItem(UUID id) {
        Item item = this.asItem();
        item.setId(id);
        return item;
    }
}
