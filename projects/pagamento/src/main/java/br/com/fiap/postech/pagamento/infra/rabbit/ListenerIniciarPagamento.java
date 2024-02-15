package br.com.fiap.postech.pagamento.infra.rabbit;

import br.com.fiap.postech.pagamento.aplicacao.RealizarPagamento;
import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerIniciarPagamento {
    @Autowired
    private RealizarPagamento realizarPagamento;
    @RabbitListener(queues = RabbitMQConstants.QUEUE_INICIAR_PAGAMENTO_IN)
    public void receiveMessage(PedidoDto pedido) {
        realizarPagamento.executa(pedido);
    }
}