package com.github.themidgart.kafka.exchange.person

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.NoArgsConstructor
import java.io.Serializable

@NoArgsConstructor
data class PersonDto(
    @JsonProperty("id") val id: String?,
    @JsonProperty("lastName") val lastName: String?,
    @JsonProperty("firstName") val firstName: String?,
    @JsonProperty("email") val email: String?,
    @JsonProperty("age") val age: Int?,
    @JsonProperty("status") val status: PersonStatus?
) : Serializable {
    override fun toString(): String {
        return "PersonDto(id=$id, lastName=$lastName, firstName=$firstName, email=$email, age=$age, status=$status)"
    }
}

