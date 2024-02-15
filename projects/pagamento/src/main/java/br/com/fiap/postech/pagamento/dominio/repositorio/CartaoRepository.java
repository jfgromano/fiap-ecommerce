package br.com.fiap.postech.pagamento.dominio.repositorio;

import br.com.fiap.postech.pagamento.dominio.entidade.Cartao;

import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository {
    Cartao salvar(Cartao cartao);
    Optional<Cartao> buscarPorId(UUID id);
    Optional<Cartao> buscarPorToken(String token);
}
