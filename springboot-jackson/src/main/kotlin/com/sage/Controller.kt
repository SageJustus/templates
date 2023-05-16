package com.sage

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/1")
    fun hello(): Person{
        return Person(116391232976064512L)
    }

    @GetMapping("/2")
    fun hello2(): Student{
        return Student(116391232976064512L)
    }

    @GetMapping("/3")
    fun hello3(): Product{
        return Product(116391232976064512L)
    }

}

data class Person(
    val id: Long
)

data class Student(
    val id: Long? = null
)

