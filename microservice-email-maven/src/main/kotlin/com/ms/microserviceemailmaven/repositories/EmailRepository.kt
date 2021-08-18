package com.ms.microserviceemailmaven.repositories

import com.ms.microserviceemailmaven.models.EmailModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmailRepository : JpaRepository<EmailModel,UUID> {
}