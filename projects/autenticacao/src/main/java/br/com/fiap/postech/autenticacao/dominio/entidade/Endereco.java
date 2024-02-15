package br.com.fiap.postech.autenticacao.dominio.entidade;

import br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects.Estado;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "enderecos")
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Estado estado;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @OneToOne(mappedBy = "endereco")
    private Usuario usuario;

    public Endereco(){}
    public Endereco(String rua, String numero, String bairro, String cidade, Estado estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.id = null;
    }

    public String getRua() {
        return rua;
    }

    public Endereco setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Endereco setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Endereco setId(UUID id) {
        this.id = id;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Endereco setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public void atualiza(Endereco endereco) {
        this.setRua(endereco.getRua());
        this.setEstado(endereco.getEstado());
        this.setBairro(endereco.getBairro());
        this.setCidade(endereco.getCidade());
        this.setNumero(endereco.getNumero());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cidade, endereco.cidade) && estado == endereco.estado && Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, numero, bairro, cidade, estado, id);
    }
}