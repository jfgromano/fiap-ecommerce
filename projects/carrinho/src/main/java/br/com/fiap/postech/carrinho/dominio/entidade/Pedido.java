package br.com.fiap.postech.carrinho.dominio.entidade;

import br.com.fiap.postech.carrinho.dominio.enums.StatusPedido;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Pedido {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private UUID idUsuario;

    @OneToMany
    @JoinColumn(name="id_pedido")
    private List<ItemPedido> itensPedido;

    public static Pedido pendente(UUID uuid) {
        return new Pedido(uuid, StatusPedido.PENDENTE);
    }

    public Pedido() {
    }

    public Pedido(UUID id, StatusPedido status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Pedido setId(UUID id) {
        this.id = id;
        return this;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public Pedido setStatus(StatusPedido status) {
        this.status = status;
        return this;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Pedido setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
        return this;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public Pedido setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
}
