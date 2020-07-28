package com.asleonov.chat.handler

import com.asleonov.chat.entity.Person
import com.asleonov.chat.service.PersonService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class PersonHandler(val personService: PersonService) {
    companion object {
        const val ID_PATH_PARAM: String = "{id}"
    }

    fun findAll(serverRequest: ServerRequest): Mono<ServerResponse> = ServerResponse.ok()
            .body(personService
                            .findAll()
                            .collectList())

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> = serverRequest.bodyToMono(Person::class.java)
            .flatMap { body ->
                ServerResponse
                        .ok()
                        .body(personService.update(body))
            }

    fun update(serverRequest: ServerRequest): Mono<ServerResponse> = serverRequest.bodyToMono(Person::class.java)
            .flatMap { body ->
                body.personId = serverRequest.pathVariable(ID_PATH_PARAM).toLong()
                return@flatMap ServerResponse.ok()
                            .body(personService.update(body))
            }

    fun delete(serverRequest: ServerRequest) : Mono<ServerResponse> = ServerResponse.ok()
            .body(personService
                    .delete(Person(serverRequest.pathVariable(ID_PATH_PARAM).toLong())))

}