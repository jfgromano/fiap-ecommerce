package br.com.fiap.postech.carrinho.dominio.exception;

public class PedidoNaoEncontradoException extends DominioException{
    public PedidoNaoEncontradoException() {
        super("Não foi possivel localizar o pedido!");
        this.codigo = 404;
    }
}
