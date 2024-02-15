package br.com.fiap.postech.carrinho.infra.rabbit;

import br.com.fiap.postech.carrinho.aplicacao.AtualizarStatusPedido;
import br.com.fiap.postech.carrinho.dominio.dto.FalhaPedidoDto;
import br.com.fiap.postech.carrinho.dominio.enums.StatusPedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FalhaPedidoListener {
    @Autowired
    private AtualizarStatusPedido atualizarStatusPedido;

    @RabbitListener(queues = RabbitConstants.QUEUE_FALHA_PEDIDO_IN)
    public void falhaPedido(FalhaPedidoDto falha) {
        atualizarStatusPedido.executa(falha.pedido().idPedido(), StatusPedido.valueOf(falha.tipo()));
    }
}
