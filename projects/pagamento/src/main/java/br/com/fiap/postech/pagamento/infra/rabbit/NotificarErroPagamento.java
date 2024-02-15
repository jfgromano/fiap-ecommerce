package br.com.fiap.postech.pagamento.infra.rabbit;

import br.com.fiap.postech.pagamento.dominio.dto.FalhaPedidoDto;
import br.com.fiap.postech.pagamento.dominio.dto.PedidoDto;
import br.com.fiap.postech.pagamento.dominio.gateway.NotificarErroPagamentoGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificarErroPagamento implements NotificarErroPagamentoGateway {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void executa(PedidoDto pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_ROLLBACK_ESTOQUE_OUT, pedido);
        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_FALHA_PEDIDO_OUT, FalhaPedidoDto.pagamento(pedido));
    }
}
