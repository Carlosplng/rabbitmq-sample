package com.carlos.config;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = RabbitMQConfig.exchange, durable = "true", type = "topic"),
            value = @Queue(value = RabbitMQConfig.queue, durable = "true"),
            key = "demo.#"))
    public void receive(String payload, Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        LOGGER.info("消费内容为：{}", payload);

        RabbitMQUtils.askMessage(channel, tag, LOGGER);
    }
}
