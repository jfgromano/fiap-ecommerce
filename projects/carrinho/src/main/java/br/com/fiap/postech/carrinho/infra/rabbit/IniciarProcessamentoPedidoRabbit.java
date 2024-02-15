package br.com.fiap.postech.carrinho.infra.rabbit;

import br.com.fiap.postech.carrinho.dominio.dto.PedidoDto;
import br.com.fiap.postech.carrinho.dominio.gateway.IniciarProcessamentoPedido;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.fiap.postech.carrinho.infra.rabbit.RabbitConstants.*;

@Component
public class IniciarProcessamentoPedidoRabbit implements IniciarProcessamentoPedido {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void executa(PedidoDto pedidoDto) {
        rabbitTemplate.convertAndSend(QUEUE_SEPARAR_ESTOQUE_OUT, pedidoDto);
    }
}
