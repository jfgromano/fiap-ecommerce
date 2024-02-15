package br.com.fiap.postech.autenticacao.dominio.entidade;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String email;
    private String numeroCelular;
    @OneToOne(mappedBy = "contato")
    private Usuario usuario;

    public Contato(){}

    public Contato(String email, String numeroCelular) {
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    public UUID getId() {
        return id;
    }

    public Contato setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contato setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public Contato setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Contato setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public void atualiza(Contato contato) {
        this.setEmail(contato.getEmail());
        this.setNumeroCelular(contato.getNumeroCelular());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) && Objects.equals(email, contato.email) && Objects.equals(numeroCelular, contato.numeroCelular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, numeroCelular);
    }
}
