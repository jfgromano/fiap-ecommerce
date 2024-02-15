package br.com.fiap.postech.gestaoitens.infra.rabbit;

import br.com.fiap.postech.gestaoitens.dominio.dto.FalhaPedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.gateway.NotificarErroPedidoGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificarErroPedido implements NotificarErroPedidoGateway {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void executa(FalhaPedidoDto falhaDto) {
        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_FALHA_PEDIDO_OUT, falhaDto);
    }
}
