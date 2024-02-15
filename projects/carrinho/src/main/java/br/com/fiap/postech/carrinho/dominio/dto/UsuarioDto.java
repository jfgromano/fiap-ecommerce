package br.com.fiap.postech.carrinho.dominio.dto;

import java.util.Objects;
import java.util.UUID;

public class UsuarioDto {
    private String token;
    private UUID id;

    public UsuarioDto(UUID id, String token) {
        this.id = id;
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto usuarioDto = (UsuarioDto) o;
        return Objects.equals(id, usuarioDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
