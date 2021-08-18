package com.ms.microserviceemailmaven.services

import com.ms.microserviceemailmaven.enums.StatusEmail
import com.ms.microserviceemailmaven.models.EmailModel
import com.ms.microserviceemailmaven.repositories.EmailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EmailService {

    @Autowired
    lateinit var emailRepository : EmailRepository
    @Autowired
    lateinit var emailSender : JavaMailSender

    fun sendEmail(email: EmailModel): EmailModel {

        email.sendDateEmail = LocalDateTime.now()

        try {
            val message = SimpleMailMessage()
            message.setFrom(email.emailFrom)
            message.setTo(email.emailTo)
            message.setSubject(email.subject)
            message.setText(email.text)
            emailSender.send(message)

            email.statusEmail=StatusEmail.SEND
        }catch (e: MailException){
            e.printStackTrace()
            email.statusEmail=StatusEmail.ERROR
        }finally {
            return emailRepository.save(email)
        }

    }




}