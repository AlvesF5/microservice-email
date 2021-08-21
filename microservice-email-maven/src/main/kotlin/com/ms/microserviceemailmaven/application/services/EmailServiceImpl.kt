package com.ms.microserviceemailmaven.application.services

import com.ms.microserviceemailmaven.application.entities.enums.StatusEmail
import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import com.ms.microserviceemailmaven.application.ports.EmailRepository
import com.ms.microserviceemailmaven.application.ports.EmailService
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import java.time.LocalDateTime
import java.util.*

class EmailServiceImpl(val emailSender : JavaMailSender, val emailRepository : EmailRepository) : EmailService {

    @Override
    override fun sendEmail(email: EmailModel): EmailModel {

        email.sendDateEmail = LocalDateTime.now()

        try {
            val message = SimpleMailMessage()
            message.setFrom(email.emailFrom)
            message.setTo(email.emailTo)
            message.setSubject(email.subject)
            message.setText(email.text)
            emailSender.send(message)

            email.statusEmail= StatusEmail.SEND
        }catch (e: MailException){
            e.printStackTrace()
            email.statusEmail= StatusEmail.ERROR
        }finally {
            return emailRepository.save(email)
        }


        }

    @Override
    override fun findById(emailId: UUID): Optional<EmailModel> {
        return emailRepository.findByEmailId(emailId)
    }

}