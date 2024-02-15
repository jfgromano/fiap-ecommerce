package br.com.fiap.postech.carrinho.dominio.exception;

public class ItemNaoEncontradoException extends DominioException {
    public ItemNaoEncontradoException() {
        super("Não foi possivel localizar o item!");
        this.codigo = 404;
    }
}
