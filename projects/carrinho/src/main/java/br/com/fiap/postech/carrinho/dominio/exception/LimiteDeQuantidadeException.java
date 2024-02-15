package br.com.fiap.postech.carrinho.dominio.exception;

public class LimiteDeQuantidadeException extends DominioException {
    public LimiteDeQuantidadeException() {
        super("Não é possivel adicionar essa quantidade de itens!");
        this.codigo = 400;
    }
}
