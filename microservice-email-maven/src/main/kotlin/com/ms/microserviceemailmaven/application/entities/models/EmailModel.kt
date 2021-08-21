package com.ms.microserviceemailmaven.application.entities.models

import com.ms.microserviceemailmaven.application.entities.enums.StatusEmail
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TB_EMAIL")
class EmailModel(val ownerRef : String = "",
                 val emailFrom : String = "",
                 val emailTo : String = "",
                 val subject : String = "",
                 @Column(columnDefinition = "")
                 val text : String = "") {

     @Id
     val emailId : UUID = UUID.randomUUID()

     var sendDateEmail : LocalDateTime? = null
     var statusEmail : StatusEmail? = null






}