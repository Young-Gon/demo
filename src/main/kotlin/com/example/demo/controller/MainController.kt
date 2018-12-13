package com.example.demo.controller

import com.example.demo.service.MainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @Autowired
    lateinit var mainService: MainService

    @GetMapping("personList")
    fun personList() = mainService.getPersonList()

    @PostMapping("insertPerson")
    fun insertPerson(name:String, country:String)=with(mainService) {
        insertPerson(name,country)
    }

    @GetMapping("orderList")
    fun orderList(personId:Int) = mainService.getOrderList(personId)

    @PostMapping("insertOrder")
    fun insertOrder(orderName:String, person_id:Int): ResponseEntity<*> {
        val orderEntity = mainService.insertOrder(orderName, person_id)
        if (orderEntity == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        return ResponseEntity.ok().body(orderEntity)
    }
}