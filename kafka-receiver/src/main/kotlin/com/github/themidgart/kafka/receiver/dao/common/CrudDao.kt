package com.github.themidgart.kafka.receiver.dao.common

import com.github.themidgart.kafka.receiver.entity.AbstractEntity
import java.util.UUID

/**
 * Common interface for DAO layer
 * @param E - Entity
 */
interface CrudDao<E : AbstractEntity> {
    fun create(entity: E): E
    fun find(id: UUID): E
    fun update(entity: E): E
    fun delete(id: UUID)
}