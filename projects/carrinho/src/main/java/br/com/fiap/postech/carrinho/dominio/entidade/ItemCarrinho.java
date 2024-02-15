package br.com.fiap.postech.carrinho.dominio.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "itens_carrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private UUID idUsuario;
    private UUID idItem;
    private Integer quantidade;

    @Transient
    private BigDecimal valorUnitario;
    @Transient
    private String nome;
    @Transient
    private Integer quantidadeDisponivel;

    public ItemCarrinho() {

    }

    public ItemCarrinho(UUID idUsuario, UUID idItem, Integer quantidade) {
        this.idUsuario = idUsuario;
        this.idItem = idItem;
        this.quantidade = quantidade;
    }

    public UUID getId() {
        return id;
    }

    public ItemCarrinho setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public ItemCarrinho setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UUID getIdItem() {
        return idItem;
    }

    public ItemCarrinho setIdItem(UUID idItem) {
        this.idItem = idItem;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemCarrinho setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public ItemCarrinho setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ItemCarrinho setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public ItemCarrinho setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinho itemCarrinho = (ItemCarrinho) o;
        return Objects.equals(id, itemCarrinho.id) && Objects.equals(idUsuario, itemCarrinho.idUsuario) && Objects.equals(idItem, itemCarrinho.idItem) && Objects.equals(quantidade, itemCarrinho.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idItem, quantidade);
    }

    public void aumentarQuantidade(int i) {
        this.quantidade += i;
    }
}
