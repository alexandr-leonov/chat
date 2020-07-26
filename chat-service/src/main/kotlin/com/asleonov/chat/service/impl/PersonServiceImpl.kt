package com.asleonov.chat.service.impl

import com.asleonov.chat.entity.Person
import com.asleonov.chat.repository.PersonRepository
import com.asleonov.chat.service.CrudService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PersonServiceImpl(val personRepository: PersonRepository) : CrudService<Person> {
    override fun findAll(): Flux<Person> = personRepository.findAll()

    override fun update(t: Person): Mono<Person> = personRepository.save(t)

    override fun delete(t: Person): Mono<Person> = personRepository.deleteById(t.personId).thenReturn(t)

    override fun deleteAll(): Mono<Void> = personRepository.deleteAll()

    override fun find(t: Person): Mono<Person> = personRepository.findById(t.personId)
}