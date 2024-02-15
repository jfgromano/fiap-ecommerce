package br.com.fiap.postech.pagamento.infra.rabbit;

import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;
import br.com.fiap.postech.pagamento.dominio.gateway.NotificarSucessoPagamentoGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificarSucessoPagamento implements NotificarSucessoPagamentoGateway {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void executa(PedidoDto pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_CONCLUIR_PEDIDO_OUT, pedido);
    }
}
