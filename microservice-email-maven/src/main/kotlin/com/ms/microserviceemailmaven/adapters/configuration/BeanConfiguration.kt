package com.ms.microserviceemailmaven.adapters.configuration

import com.ms.microserviceemailmaven.MicroserviceEmailMavenApplication
import com.ms.microserviceemailmaven.application.ports.EmailRepository
import com.ms.microserviceemailmaven.application.services.EmailServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender

@Configuration
@ComponentScan(basePackageClasses = arrayOf(MicroserviceEmailMavenApplication::class))
class BeanConfiguration {

    @Bean
    fun emailServiceImpl(emailRepository: EmailRepository, emailSender : JavaMailSender) : EmailServiceImpl{
        return EmailServiceImpl(emailSender, emailRepository)
    }

}