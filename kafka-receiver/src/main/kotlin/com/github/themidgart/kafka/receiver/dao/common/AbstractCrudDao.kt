package com.github.themidgart.kafka.receiver.dao.common

import com.github.themidgart.kafka.receiver.entity.AbstractEntity
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert
import java.util.*

/**
 * Common abstraction for DAO layer
 * @param E - Entity
 */
abstract class AbstractCrudDao<E : AbstractEntity> :
    CrudDao<E> {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Transactional
    override fun create(entity: E): E {
        entityManager.persist(entity)
        return entity
    }

    override fun find(id: UUID): E {
        Assert.notNull(id, "Id must be not null")
        return entityManager.find(getEntityClass(), id)
    }

    override fun update(entity: E): E {
        Assert.notNull(entity.id, "Id must be not null")
        entityManager.merge(entity)
        return entity
    }

    @Transactional
    override fun delete(id: UUID) {
        Assert.notNull(id, "Id must be not null")
        val entity:E = entityManager.getReference(getEntityClass(), id)
        entityManager.remove(entity)
    }

    protected abstract fun getEntityClass(): Class<E>
}