package com.asleonov.chat.service

import com.asleonov.chat.entity.Person
import com.asleonov.chat.facade.CrudFacade
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
open class PersonService(val crudFacade: CrudFacade<Person>) {

    fun findAll(): Flux<Person> = crudFacade.findAll()

    fun findById(id: Long): Mono<Person> = crudFacade.find(Person(id, "","",""))

    fun update(t:Person): Mono<Person> = crudFacade.update(t)

    fun delete(t:Person): Mono<Person> = crudFacade.delete(t)

    fun deleteAll(): Mono<Void> = crudFacade.deleteAll()

}