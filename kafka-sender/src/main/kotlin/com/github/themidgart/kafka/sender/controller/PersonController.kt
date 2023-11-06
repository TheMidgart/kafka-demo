package com.github.themidgart.kafka.sender.controller

import com.github.themidgart.kafka.exchange.common.CrudMethod
import com.github.themidgart.kafka.exchange.person.PersonDto
import com.github.themidgart.kafka.exchange.person.PersonEventBody
import com.github.themidgart.kafka.sender.sender.PersonSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/person")
class PersonController(
    @Autowired
    val personSender: PersonSender
) {

    @PostMapping
    fun createPerson(@RequestBody personDto: PersonDto): PersonDto {
        val event = PersonEventBody(CrudMethod.CREATE, personDto)
        personSender.sendEvent(event)
        return personDto
    }

    @PutMapping
    fun updatePerson(@RequestBody personDto: PersonDto): PersonDto {
        val event = PersonEventBody(CrudMethod.UPDATE, personDto)
        personSender.sendEvent(event)
        return personDto
    }
}