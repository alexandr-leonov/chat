package com.asleonov.chat.service

import com.asleonov.chat.entity.Person
import com.asleonov.chat.facade.CrudFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.IllegalArgumentException

@Service
open class PersonService(val personFacade: CrudFacade<Person>) {

    fun findAll(): Flux<Person> = personFacade.findAll()

    fun findById(id: Long): Mono<Person> = personFacade.find(Person(id))

    /*
     * Update only not null fields
     */
    @Transactional
    fun update(person: Person): Mono<Person> = personFacade.update(person)

    @Transactional
    fun delete(person: Person): Mono<Person> = personFacade.delete(person)

    @Transactional
    fun deleteAll(): Mono<Void> = personFacade.deleteAll()

}