package com.ms.microserviceemailmaven.adapters.outbound

import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import com.ms.microserviceemailmaven.application.ports.EmailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import java.awt.print.Pageable
import java.util.*

@Primary
@Component
class PostgresEmailRepository(val emailRepository: SpringDataPostgresEmailRepository) : EmailRepository{

    @Override
    override fun save(email: EmailModel): EmailModel {
       return emailRepository.save(email)
    }


    @Override
    override fun findByEmailId(emailId: UUID): Optional<EmailModel> {
        return emailRepository.findById(emailId)
    }

}