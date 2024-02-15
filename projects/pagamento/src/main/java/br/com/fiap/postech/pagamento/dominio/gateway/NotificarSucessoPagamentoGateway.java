package br.com.fiap.postech.pagamento.dominio.gateway;

import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;

public interface NotificarSucessoPagamentoGateway {
    void executa(PedidoDto pedido);
}
