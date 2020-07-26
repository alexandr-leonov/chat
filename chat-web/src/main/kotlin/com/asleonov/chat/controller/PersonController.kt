package com.asleonov.chat.controller

import com.asleonov.chat.entity.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController("/persons")
class PersonController/*(val personService: CrudService<Person>)*/ {

    @GetMapping
    fun persons() : Flux<Person> = Flux.empty() /*personService.findAll()*/

}