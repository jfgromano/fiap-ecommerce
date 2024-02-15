package br.com.fiap.postech.carrinho.infra.rabbit;

import br.com.fiap.postech.carrinho.aplicacao.AtualizarStatusPedido;
import br.com.fiap.postech.carrinho.dominio.dto.PedidoDto;
import br.com.fiap.postech.carrinho.dominio.enums.StatusPedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcluirPedidoListener {
    @Autowired
    private AtualizarStatusPedido atualizarStatusPedido;

    @RabbitListener(queues = RabbitConstants.QUEUE_CONCLUIR_PEDIDO_IN)
    public void concluirPedido(PedidoDto pedido) {
        atualizarStatusPedido.executa(pedido.idPedido(), StatusPedido.CONCLUIDO);
    }
}
