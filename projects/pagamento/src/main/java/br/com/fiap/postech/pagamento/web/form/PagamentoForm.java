package br.com.fiap.postech.pagamento.web.form;

import br.com.fiap.postech.pagamento.dominio.entidade.Pagamento;

public record PagamentoForm(

) {
    public Pagamento asPagamento() {
        return new Pagamento();
    }
}
