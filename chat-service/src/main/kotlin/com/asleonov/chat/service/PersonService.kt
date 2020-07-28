package com.asleonov.chat.service

import com.asleonov.chat.entity.Person
import com.asleonov.chat.facade.CrudFacade
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
open class PersonService(val personFacade: CrudFacade<Person>) {

    fun findAll(): Flux<Person> = personFacade.findAll()

    fun findById(id: Long): Mono<Person> = personFacade.find(Person(id))

    /*
     * Update only not null fields
     */
    fun update(person: Person): Mono<Person> {
        return personFacade.find(person)
                .flatMap { findPerson ->
                    if (person.name.isNullOrBlank()) person.name = findPerson.name
                    if (person.username.isNullOrBlank()) person.username = findPerson.username
                    if (person.password.isNullOrBlank()) person.password = findPerson.password

                    return@flatMap personFacade.update(person)
                }
                // When user not found need create him
                .switchIfEmpty(personFacade.update(person))
    }

    fun delete(person: Person): Mono<Person> = personFacade.delete(person)

    fun deleteAll(): Mono<Void> = personFacade.deleteAll()

}