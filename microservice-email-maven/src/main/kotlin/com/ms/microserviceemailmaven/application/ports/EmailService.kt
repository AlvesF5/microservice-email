package com.ms.microserviceemailmaven.application.ports

import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import java.util.*

interface EmailService {

    fun sendEmail(email : EmailModel) : EmailModel
    fun findById(emailId : UUID) : Optional<EmailModel>

}