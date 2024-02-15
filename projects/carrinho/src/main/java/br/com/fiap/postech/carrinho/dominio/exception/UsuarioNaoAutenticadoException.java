package br.com.fiap.postech.carrinho.dominio.exception;

public class UsuarioNaoAutenticadoException extends DominioException {
    public UsuarioNaoAutenticadoException() {
        super("Você deve estar autenticado para continuar!");
        this.codigo = 403;
    }
}
