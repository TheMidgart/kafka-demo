package com.github.themidgart.kafka.sender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SenderRunner

fun main(args: Array<String>) {
    runApplication<SenderRunner>(*args)
}
