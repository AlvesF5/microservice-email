package com.ms.microserviceemailmaven.models

import com.ms.microserviceemailmaven.enums.StatusEmail
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

     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     val emailId : UUID? = null

     var sendDateEmail : LocalDateTime? = null
     var statusEmail : StatusEmail? = null





}