package br.com.fiap.postech.gestaoitens.infra.rabbit;

import br.com.fiap.postech.gestaoitens.aplicacao.AlterarEstoqueItem;
import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerSepararEstoque {
    @Autowired
    private AlterarEstoqueItem alterarEstoqueItem;
    @RabbitListener(queues = RabbitMQConstants.QUEUE_SEPARAR_ESTOQUE_IN)
    public void receiveMessage(PedidoDto pedido) {
        alterarEstoqueItem.executa(pedido);
    }
}