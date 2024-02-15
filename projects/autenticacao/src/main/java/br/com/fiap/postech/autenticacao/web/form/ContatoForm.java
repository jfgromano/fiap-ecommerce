package br.com.fiap.postech.autenticacao.web.form;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContatoForm(
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "^\\([1-9]{2}\\) [9]{1}[0-9]{4}-[0-9]{4}$", message = "deve ser um numero de celular no formato (xx) 9xxxx-xxxx")
        String numeroCelular) {
    public Contato asContato() {
        return new Contato(
                this.email,
                this.numeroCelular
        );
    }
}