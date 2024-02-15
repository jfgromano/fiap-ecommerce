package br.com.fiap.postech.gestaoitens.dominio.exception;

import java.util.UUID;

public class ItemForaDeEstoqueException extends DominioException {
    public ItemForaDeEstoqueException(Integer quantidadeAtual, UUID uuid) {
        super("O estoque do item " + uuid.toString() + " é de " + quantidadeAtual);
    }
}
