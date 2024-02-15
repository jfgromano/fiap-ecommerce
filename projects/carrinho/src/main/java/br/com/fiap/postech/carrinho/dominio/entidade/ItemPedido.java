package br.com.fiap.postech.carrinho.dominio.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private UUID idUsuario;
    @Column(name = "id_pedido")
    private UUID idPedido;
    private UUID idItem;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private String nome;

    public static List<ItemPedido> fromItensCarrinho(UUID idPedido, List<ItemCarrinho> itensCarrinho) {
        List<ItemPedido> itensPedido = new ArrayList<>();
        for(ItemCarrinho i : itensCarrinho) {
            ItemPedido itemPedido = new ItemPedido(idPedido, i);
            itensPedido.add(itemPedido);
        }
        return itensPedido;
    }

    public ItemPedido() {
    }

    public ItemPedido(UUID idPedido, ItemCarrinho i) {
        this.setIdItem(i.getIdItem());
        this.setIdPedido(idPedido);
        this.setNome(i.getNome());
        this.setQuantidade(i.getQuantidade());
        this.setIdUsuario(i.getIdUsuario());
        this.setValorUnitario(i.getValorUnitario());
    }
    public UUID getId() {
        return id;
    }

    public ItemPedido setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public ItemPedido setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UUID getIdItem() {
        return idItem;
    }

    public ItemPedido setIdItem(UUID idItem) {
        this.idItem = idItem;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemPedido setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public ItemPedido setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ItemPedido setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public ItemPedido setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
        return this;
    }
}
