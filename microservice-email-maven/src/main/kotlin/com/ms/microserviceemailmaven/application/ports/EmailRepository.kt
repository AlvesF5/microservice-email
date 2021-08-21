package com.ms.microserviceemailmaven.application.ports

import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import org.springframework.data.domain.Page
import java.awt.print.Pageable
import java.util.*

interface EmailRepository {

    fun save(email : EmailModel) : EmailModel
    fun findByEmailId(emailId : UUID) : Optional<EmailModel>

}