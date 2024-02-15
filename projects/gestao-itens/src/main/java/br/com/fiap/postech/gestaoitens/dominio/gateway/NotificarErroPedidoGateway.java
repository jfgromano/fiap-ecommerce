package br.com.fiap.postech.gestaoitens.dominio.gateway;

import br.com.fiap.postech.gestaoitens.dominio.dto.FalhaPedidoDto;

public interface NotificarErroPedidoGateway {
    void executa(FalhaPedidoDto estoque);
}
