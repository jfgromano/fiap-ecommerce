package br.com.fiap.postech.pagamento.dominio.entidade;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private UUID pedidoId;
    private UUID usuarioId;
    private BigDecimal valor;
    @ManyToOne
    private Cartao cartao;

    public Pagamento() {
    }

    public Pagamento(UUID pedidoId, UUID usuarioId, BigDecimal valor) {
        this.pedidoId = pedidoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public Pagamento setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public Pagamento setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Pagamento setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
    public UUID getUsuarioId() {
        return usuarioId;
    }

    public Pagamento setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Pagamento setCartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }
}
