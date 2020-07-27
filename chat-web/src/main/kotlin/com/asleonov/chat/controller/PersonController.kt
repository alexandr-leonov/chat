package com.asleonov.chat.controller

import com.asleonov.chat.entity.Person
import com.asleonov.chat.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/persons")
class PersonController(val personService: PersonService) {

    @GetMapping
    fun persons() : Flux<Person> = personService.findAll()

}