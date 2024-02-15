package br.com.fiap.postech.autenticacao.dominio.exception;

public class ContatoNaoCadastradoException extends DominioException{
    public ContatoNaoCadastradoException() {
        super("Nao foi possivel localizar o contato!");
        this.codigo = 404;
    }
}
