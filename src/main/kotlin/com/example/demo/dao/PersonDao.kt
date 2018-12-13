package com.example.demo.dao

import com.example.demo.entity.PersonEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao : CrudRepository<PersonEntity, Int> {
    fun findFirstById(id:Int):PersonEntity?
}