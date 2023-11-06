package com.github.themidgart.kafka.receiver.mapper

import com.github.themidgart.kafka.exchange.person.PersonDto
import com.github.themidgart.kafka.receiver.entity.Person
import org.mapstruct.Mapper

@Mapper(componentModel = "Spring")
interface PersonMapper {
    fun map(personDto: PersonDto): Person
}