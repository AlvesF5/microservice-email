package com.ms.microserviceemailmaven.controllers

import com.ms.microserviceemailmaven.dtos.EmailDTO
import com.ms.microserviceemailmaven.models.EmailModel
import com.ms.microserviceemailmaven.services.EmailService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class EmailController {

    @Autowired
    lateinit var emailService : EmailService

    @PostMapping("/send-email")
    fun  sendEmail(@RequestBody @Valid emailDTO : EmailDTO) : ResponseEntity<EmailModel>{

        val email : EmailModel =  emailDTO.transformarParaEmail()

        emailService.sendEmail(email)

        return ResponseEntity(email, HttpStatus.CREATED)

    }
}