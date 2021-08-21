package com.ms.microserviceemailmaven.adapters.inbound.dtos

import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class EmailDTO{

    @field:NotBlank
    val ownerRef: String? = ""
    @field:NotBlank @field:Email
    val emailFrom: String? = ""
    @field:NotBlank @field:Email
    val emailTo: String? = ""
    @field:NotBlank
    val subject: String? = ""
    @field:NotBlank
    val text: String? = ""

    fun transformarParaEmail() : EmailModel {
        return EmailModel(ownerRef=this.ownerRef!!,emailFrom = this.emailFrom!!, emailTo = this.emailTo!!, subject = this.subject!!, text = this.text!!)
    }
}
