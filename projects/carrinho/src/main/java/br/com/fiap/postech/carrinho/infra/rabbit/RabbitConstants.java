package br.com.fiap.postech.carrinho.infra.rabbit;

public class RabbitConstants {
    //Filas para separacao de estoque
    public static final String QUEUE_SEPARAR_ESTOQUE_OUT = "gestao_itens.v1.separar_estoque";

    //Atualizacao de status do pedido
    public static final String QUEUE_FALHA_PEDIDO_IN = "carrinho.v1.falha_pedido";
    public static final String QUEUE_CONCLUIR_PEDIDO_IN = "carrinho.v1.concluir_pedido";
}
