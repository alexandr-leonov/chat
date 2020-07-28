package com.asleonov.chat.facade.impl

import com.asleonov.chat.entity.Person
import com.asleonov.chat.facade.CrudFacade
import com.asleonov.chat.repository.PersonRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class PersonFacadeImpl(val personRepository: PersonRepository) : CrudFacade<Person> {
    override fun findAll(): Flux<Person> = personRepository.findAll()

    override fun update(t: Person): Mono<Person> = personRepository.save(t)

    override fun delete(t: Person): Mono<Person> = personRepository.deleteById(t.personId!!).thenReturn(t)

    override fun deleteAll(): Mono<Void> = personRepository.deleteAll()

    override fun find(t: Person): Mono<Person> = personRepository.findById(t.personId!!)
}