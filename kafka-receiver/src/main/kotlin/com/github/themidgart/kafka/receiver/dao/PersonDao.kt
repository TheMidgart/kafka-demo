package com.github.themidgart.kafka.receiver.dao

import com.github.themidgart.kafka.receiver.dao.common.AbstractCrudDao
import com.github.themidgart.kafka.receiver.entity.Person
import org.springframework.stereotype.Repository

@Repository
class PersonDao : AbstractCrudDao<Person>() {
     override fun getEntityClass(): Class<Person> {
        return Person::class.java
    }
}