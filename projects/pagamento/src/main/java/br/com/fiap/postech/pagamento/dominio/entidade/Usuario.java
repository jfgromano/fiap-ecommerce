package br.com.fiap.postech.pagamento.dominio.entidade;

import java.util.UUID;

public class Usuario {
    private UUID id;

    public Usuario(UUID id, Boolean admin) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
