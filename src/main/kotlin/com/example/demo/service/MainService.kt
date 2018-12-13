package com.example.demo.service

import com.example.demo.dao.OrderDao
import com.example.demo.dao.PersonDao
import com.example.demo.entity.PersonEntity
import com.example.demo.entity.TbOrderEntity
import org.springframework.stereotype.Service
import javax.annotation.Resource
import javax.transaction.Transactional

@Service
class MainService
{
    @Resource
    private lateinit var personDao: PersonDao

    @Resource
    private lateinit var orderDao: OrderDao

    fun getPersonList() = personDao.findAll()

    @Transactional
    fun insertPerson(name:String, country:String) = with(personDao) {
        save(PersonEntity(name,country))
    }
    /*{
        personDao.save(PersonEntity(name,country))
    }*/


    fun getOrderList(id: Int) = orderDao.findAllByPersonId(id)

    @Transactional
    fun insertOrder(orderName:String, person_id:Int): TbOrderEntity? = with(orderDao) {
        val person=personDao.findFirstById(person_id)

        person.let { save(TbOrderEntity(orderName,person)) }
    }
}