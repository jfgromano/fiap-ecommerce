package br.com.fiap.postech.pagamento.infra.repository;

import br.com.fiap.postech.pagamento.dominio.entidade.Pagamento;
import br.com.fiap.postech.pagamento.dominio.repositorio.PagamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PagamentoRepositoryPostgresql extends JpaRepository<Pagamento, UUID>, PagamentoRepository {
    default Pagamento salvar(Pagamento pagamento) {
        return save(pagamento);
    }
}
