package com.github.themidgart.kafka.sender.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sender/api/health")
class HealthController {
    @GetMapping("/check")
    fun check(): String {
        return "Ok"
    }

    @GetMapping("/echo")
    fun echo(@RequestParam("message") echoMessage: String): ResponseEntity<String> {
        return ResponseEntity.ok(echoMessage);
    }
}