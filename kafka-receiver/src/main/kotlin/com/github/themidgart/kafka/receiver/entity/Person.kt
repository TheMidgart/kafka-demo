package com.github.themidgart.kafka.receiver.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "PERSON")
data class Person(
    @Column(name = "FIRST_NAME") var firstName: String?,
    @Column(name = "LAST_NAME") var lastName: String?,
    @Column(name = "EMAIl") var email: String?,
    @Column(name = "AGE") var age: Int?,
    @Column(name = "STATUS") var status: String?
) : AbstractEntity()

