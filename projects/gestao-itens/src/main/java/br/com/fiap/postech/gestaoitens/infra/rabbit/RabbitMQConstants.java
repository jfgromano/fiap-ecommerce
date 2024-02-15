package br.com.fiap.postech.gestaoitens.infra.rabbit;

public class RabbitMQConstants {
    public static final String QUEUE_SEPARAR_ESTOQUE_IN = "gestao_itens.v1.separar_estoque";
    public static final String QUEUE_ROLLBACK_ESTOQUE_IN = "gestao_itens.v1.rollback_estoque";
    public static final String QUEUE_INICIAR_PAGAMENTO_OUT = "pagamento.v1.iniciar_pagamento";
    public static final String QUEUE_FALHA_PEDIDO_OUT = "carrinho.v1.falha_pedido";

}
