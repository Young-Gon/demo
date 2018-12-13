package com.example.demo.dao

import com.example.demo.entity.TbOrderEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderDao : CrudRepository<TbOrderEntity, Int> {
    fun findAllByPersonId(id:Int):TbOrderEntity
}