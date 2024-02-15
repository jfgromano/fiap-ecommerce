package br.com.fiap.postech.gestaoitens.dominio.gateway;

import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;

public interface LiberarPedidoParaPagamentoGateway {
    void executa(PedidoDto pedido);
}
