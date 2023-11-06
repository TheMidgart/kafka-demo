package com.github.themidgart.kafka.receiver.receiver

import com.github.themidgart.kafka.exchange.person.PersonEventBody
import com.github.themidgart.kafka.receiver.config.KAFKA_GROUP_ID
import com.github.themidgart.kafka.receiver.config.PERSON_TOPIC_NAME
import com.github.themidgart.kafka.receiver.service.PersonService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PersonReceiver(
    @Autowired private val personService: PersonService
) {
    private val LOGGER = LoggerFactory.getLogger(PersonReceiver::class.java)

    @Transactional
    @KafkaListener(
        topics = [PERSON_TOPIC_NAME],
        groupId = KAFKA_GROUP_ID,
        properties = ["spring.json.value.default.type=com.github.themidgart.kafka.exchange.person.PersonEventBody"]
    )
    fun receive(personEventBody: PersonEventBody) {
        LOGGER.info("Received kafka message with body {}", personEventBody)
        personService.save(personEventBody)
    }
}