package com.asleonov.chat.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CrudService<T> {

    fun findAll(): Flux<T>

    fun find(t: T): Mono<T>

    fun update(t: T): Mono<T>

    fun delete(t: T): Mono<T>

    fun deleteAll(): Mono<Void>

}