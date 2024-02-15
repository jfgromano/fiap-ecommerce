package br.com.fiap.postech.pagamento.dominio.gateway;

import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;

public interface NotificarErroPagamentoGateway {
    void executa(PedidoDto pedido);
}
