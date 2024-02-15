package br.com.fiap.postech.carrinho.infra.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static br.com.fiap.postech.carrinho.infra.rabbit.RabbitConstants.QUEUE_CONCLUIR_PEDIDO_IN;
import static br.com.fiap.postech.carrinho.infra.rabbit.RabbitConstants.QUEUE_FALHA_PEDIDO_IN;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queueConcluidPedido() {
        return new Queue(QUEUE_CONCLUIR_PEDIDO_IN);
    }
    @Bean
    public Queue queueFalhaPedido() {
        return new Queue(QUEUE_FALHA_PEDIDO_IN);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(
            RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}