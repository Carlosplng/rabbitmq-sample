package com.carlos.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * rabbitmq 的配置类
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String queue = "demo_queue";
    public static final String exchange = "demo_exchange";
    public static final String route_key = "demo.route";
}