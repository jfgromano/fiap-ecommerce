package br.com.fiap.postech.gestaoitens.web.view;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;

import java.util.UUID;

public record ItemView(
        UUID id,
        String nome,
        String descricao,
        double quantidade,
        double valor
) {
    public ItemView(Item i) {
        this(
            i.getId(),
            i.getNome(),
            i.getDescricao(),
            i.getQuantidade(),
            i.getValor().doubleValue()
        );
    }
}
