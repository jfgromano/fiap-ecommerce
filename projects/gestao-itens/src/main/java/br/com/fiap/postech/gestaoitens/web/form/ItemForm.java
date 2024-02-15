package br.com.fiap.postech.gestaoitens.web.form;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.web.validacoes.Number;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ItemForm(
    @NotBlank
    String nome,
    @NotBlank
    String descricao,
    @NotNull
    @Number(message = "deve ser um numero")
    String quantidade,

    @NotNull
    @Number(message = "deve ser um numero")
    String valor
) {
    public Item asItem() {
        return new Item(
                this.nome,
                this.descricao,
                Integer.valueOf(this.quantidade),
                new BigDecimal(this.valor)
        );
    }
}
