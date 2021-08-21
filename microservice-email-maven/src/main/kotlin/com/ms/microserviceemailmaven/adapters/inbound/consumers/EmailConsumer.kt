package com.ms.microserviceemailmaven.adapters.inbound.consumers

import com.ms.microserviceemailmaven.adapters.inbound.dtos.EmailDTO
import com.ms.microserviceemailmaven.application.ports.EmailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer {

    @Autowired
    lateinit var emailService: EmailService

    @RabbitListener(queues = ["\${spring.rabbitmq.queue}"])
    fun  listen(@Payload emailDTO: EmailDTO){
        val email = emailDTO.transformarParaEmail()
        emailService.sendEmail(email)
        println("Email Status: ${email.statusEmail.toString()}")
    }
}