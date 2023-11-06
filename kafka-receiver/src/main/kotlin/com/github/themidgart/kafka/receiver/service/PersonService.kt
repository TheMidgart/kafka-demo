package com.github.themidgart.kafka.receiver.service

import com.github.themidgart.kafka.exchange.common.CrudMethod
import com.github.themidgart.kafka.exchange.person.PersonEventBody
import com.github.themidgart.kafka.receiver.dao.PersonDao
import com.github.themidgart.kafka.receiver.mapper.PersonMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class PersonService(@Autowired private val personDao: PersonDao) {
    private val KAFKA = "KAFKA"

    @Autowired
    private lateinit var personMapper: PersonMapper

    fun save(personEvent: PersonEventBody): UUID? {
        var person = personMapper.map(personEvent.person)

        val now = LocalDateTime.now()
        when (personEvent.method) {
            CrudMethod.CREATE -> {
                person.setTechnicalFields(KAFKA, now, KAFKA, now)
                personDao.create(person)
            }
            CrudMethod.UPDATE -> {
                person.updateTechnicalFields(KAFKA, now)
                personDao.update(person)
            }
            else -> throw IllegalArgumentException("Method should be CREATE/UPDATE")
        }
        return person.id
    }
}