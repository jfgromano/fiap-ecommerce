package br.com.fiap.postech.autenticacao.web.form;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import jakarta.validation.constraints.NotBlank;
public record AutenticacaoForm (
        @NotBlank
        String email,
        @NotBlank
        String senha
){
    public Usuario asUsuario() {
        return new Usuario(
                this.email,
                this.senha
        );
    }
}
