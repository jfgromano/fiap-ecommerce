package br.com.fiap.postech.gestaoitens.dominio.entidade;

import java.util.Objects;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private Boolean admin;

    public Usuario(UUID id, Boolean admin) {
        this.id = id;
        this.admin = admin;
    }

    public UUID getId() {
        return id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(admin, usuario.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, admin);
    }
}
