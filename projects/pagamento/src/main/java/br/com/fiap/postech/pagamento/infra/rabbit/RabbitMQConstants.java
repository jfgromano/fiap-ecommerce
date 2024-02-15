package br.com.fiap.postech.pagamento.infra.rabbit;

public class RabbitMQConstants {
    public static final String QUEUE_INICIAR_PAGAMENTO_IN = "pagamento.v1.iniciar_pagamento";
    public static final String QUEUE_CONCLUIR_PEDIDO_OUT = "carrinho.v1.concluir_pedido";
    public static final String QUEUE_ROLLBACK_ESTOQUE_OUT = "gestao_itens.v1.rollback_estoque";
    public static final String QUEUE_FALHA_PEDIDO_OUT = "carrinho.v1.falha_pedido";
}
