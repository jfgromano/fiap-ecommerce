package br.com.fiap.postech.gestaoitens.dominio.exception;

import java.util.UUID;

public class ItemNaoEncontradoException extends DominioException {
    public ItemNaoEncontradoException() {
        super("Não foi possivel localizar o item!");
        this.codigo = 404;
    }

    public ItemNaoEncontradoException(UUID uuid) {
        super("Não foi possivel localizar o item com id " + uuid.toString());
        this.codigo = 404;
    }
}
