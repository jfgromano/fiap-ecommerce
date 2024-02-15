package br.com.fiap.postech.autenticacao.dominio.exception;

public class RecursoJaExisteException extends DominioException{
    public RecursoJaExisteException(String msg) {
        super(msg);
        this.codigo = 409;
    }
}
