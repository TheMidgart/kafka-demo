package com.github.themidgart.kafka.receiver.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*
import kotlin.reflect.KClass

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    var id: UUID? = null,
    @Column(name = "CREATED_BY")
    var createdBy: String? = null,
    @Column(name = "CREATED")
    var created: LocalDateTime? = null,
    @Column(name = "UPDATED_BY")
    var updatedBy: String? = null,
    @Column(name = "UPDATED")
    var updated: LocalDateTime? = null
) {
    fun setTechnicalFields(
        createdBy: String, created: LocalDateTime,
        updatedBy: String, updated: LocalDateTime
    ) {
        this.createdBy = createdBy
        this.created = created
        this.updatedBy = updatedBy
        this.updated = updated
    }

    fun updateTechnicalFields(
        updatedBy: String,
        updated: LocalDateTime
    ) {
        this.updatedBy = updatedBy
        this.updated = updated
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as AbstractEntity
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}