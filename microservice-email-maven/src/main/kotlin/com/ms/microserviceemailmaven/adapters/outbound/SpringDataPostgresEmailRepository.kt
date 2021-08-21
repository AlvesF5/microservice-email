package com.ms.microserviceemailmaven.adapters.outbound

import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpringDataPostgresEmailRepository : JpaRepository<EmailModel, UUID> {

}