package com.github.themidgart.kafka.receiver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class KafkaReceiverApplication

fun main(args: Array<String>) {
    runApplication<KafkaReceiverApplication>(*args)
}
