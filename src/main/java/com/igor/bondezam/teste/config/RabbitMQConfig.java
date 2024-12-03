package com.igor.bondezam.teste.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue usuarioQueue() {
        return new Queue("usuario-fila", true);
    } //Duplicar método para criar mais filas

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("usuario-topic");
    } //Duplicar método para criar mais topics

    @Bean
    public Binding usuarioBindingQueue(Queue usuarioQueue, TopicExchange exchange) {
        return BindingBuilder.bind(usuarioQueue).to(exchange).with("usuario-routing-key");
    } //Duplicar método para criar mais binding
}
