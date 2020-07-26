package com.asleonov.chat.repository

import com.asleonov.chat.entity.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : ReactiveCrudRepository<Person, Long>