package com.ms.microserviceemailmaven.configs

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${spring.rabbitmq.queue}")
    lateinit var queue : String

    @Bean
    open fun queue() : Queue {
        return Queue(queue,true)
    }

    @Bean
    fun messageConverter() : Jackson2JsonMessageConverter{
        return Jackson2JsonMessageConverter()
    }
}