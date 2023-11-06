package com.github.themidgart.kafka.sender.sender

import com.github.themidgart.kafka.exchange.person.PersonEventBody
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonSender(
    @Value("\${topic.person-topic}")
    private val sendClientTopic: String,
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    fun sendEvent(personEvent: PersonEventBody) {
        kafkaTemplate.send(ProducerRecord(sendClientTopic, UUID.randomUUID().toString(), personEvent))
    }
}