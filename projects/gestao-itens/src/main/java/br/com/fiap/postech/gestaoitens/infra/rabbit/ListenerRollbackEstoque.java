package br.com.fiap.postech.gestaoitens.infra.rabbit;

import br.com.fiap.postech.gestaoitens.aplicacao.RollbackEstoqueItem;
import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerRollbackEstoque {
    @Autowired
    private RollbackEstoqueItem rollbackEstoqueItem;
    @RabbitListener(queues = RabbitMQConstants.QUEUE_ROLLBACK_ESTOQUE_IN)
    public void receiveMessage(PedidoDto pedido) {
        rollbackEstoqueItem.executa(pedido);
    }
}