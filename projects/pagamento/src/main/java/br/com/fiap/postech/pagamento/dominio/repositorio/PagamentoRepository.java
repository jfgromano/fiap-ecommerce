package br.com.fiap.postech.pagamento.dominio.repositorio;

import br.com.fiap.postech.pagamento.dominio.entidade.Pagamento;

public interface PagamentoRepository {
    Pagamento salvar(Pagamento pagamento);
}