package com.github.themidgart.kafka.exchange.person

enum class PersonStatus(val value: String) {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted")
}