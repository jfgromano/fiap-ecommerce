package br.com.fiap.postech.pagamento.dominio.entidade;


import br.com.fiap.postech.pagamento.dominio.dto.CartaoDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token"})
})
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID idUsuario;
    private String ultimosDigitosCartao;
    private String tipoCartao;
    private String token;

    public Cartao() {
    }

    public Cartao(UUID idUsuario, String ultimosDigitosCartao, String tipo, String token) {
        this.ultimosDigitosCartao = ultimosDigitosCartao;
        this.tipoCartao = tipo;
        this.token = token;
        this.idUsuario = idUsuario;
    }

    public UUID getId() {
        return id;
    }

    public Cartao setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUltimosDigitosCartao() {
        return ultimosDigitosCartao;
    }

    public Cartao setUltimosDigitosCartao(String ultimosDigitosCartao) {
        this.ultimosDigitosCartao = ultimosDigitosCartao;
        return this;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public Cartao setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Cartao setToken(String token) {
        this.token = token;
        return this;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public Cartao setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public boolean isCredito() {
        return this.tipoCartao.equals(CartaoDto.TIPO_CARTAO.CREDITO.name());
    }
}
