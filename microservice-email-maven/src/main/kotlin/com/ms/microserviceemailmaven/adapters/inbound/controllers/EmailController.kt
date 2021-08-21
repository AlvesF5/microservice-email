package com.ms.microserviceemailmaven.adapters.inbound.controllers

import com.ms.microserviceemailmaven.adapters.inbound.dtos.EmailDTO
import com.ms.microserviceemailmaven.application.entities.models.EmailModel
import com.ms.microserviceemailmaven.application.ports.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/emails")
class EmailController {

    @Autowired
    lateinit var emailService : EmailService

    @PostMapping("/send-email")
    fun  sendEmail(@RequestBody @Valid emailDTO : EmailDTO) : ResponseEntity<EmailModel>{

        val email : EmailModel =  emailDTO.transformarParaEmail()

        emailService.sendEmail(email)

        return ResponseEntity(email, HttpStatus.CREATED)

    }

    @GetMapping("/{emailId}")
    fun getEmail(@PathVariable("emailId") emailId : UUID) : ResponseEntity<Any>{

        val email : Optional<EmailModel> = emailService.findById(emailId)

        if (email.isEmpty){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado")
        }

        return ResponseEntity.status(HttpStatus.OK).body(email.get())
    }
}