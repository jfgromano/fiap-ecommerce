package br.com.fiap.postech.gestaoitens.infra.rabbit;

import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.gateway.LiberarPedidoParaPagamentoGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiberarPedidoParaPagamento implements LiberarPedidoParaPagamentoGateway {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void executa(PedidoDto pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_INICIAR_PAGAMENTO_OUT, pedido);
    }
}
