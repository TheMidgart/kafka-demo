package com.github.themidgart.kafka.exchange.person

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.themidgart.kafka.exchange.common.CrudMethod

class PersonEventBody(
    @JsonProperty("method") val method: CrudMethod,
    @JsonProperty("person") val person: PersonDto
) {
    override fun toString(): String {
        return "PersonEventBody(method=$method, person=$person)"
    }
}
