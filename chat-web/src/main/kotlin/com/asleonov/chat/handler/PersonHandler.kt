package com.asleonov.chat.handler

import com.asleonov.chat.entity.Person
import com.asleonov.chat.service.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class PersonHandler(val personService: PersonService) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    companion object {
        const val ID_PATH_PARAM: String = "id"
    }

    fun findAll(serverRequest: ServerRequest): Mono<ServerResponse> {
        log.debug("find all users")
        return ServerResponse.ok()
                .body(personService
                        .findAll()
                        .collectList())
    }

    @Transactional
    fun create(serverRequest: ServerRequest): Mono<ServerResponse> = serverRequest.bodyToMono(Person::class.java)
            .flatMap { body ->
                log.debug("create person by params {}", body)

                return@flatMap ServerResponse
                            .ok()
                            .body(personService.update(body))
            }

    fun update(serverRequest: ServerRequest): Mono<ServerResponse> = serverRequest.bodyToMono(Person::class.java)
                .flatMap { body ->
                    log.debug("update user {} by params = {}", serverRequest.pathVariable(ID_PATH_PARAM), body)
                    body.personId = serverRequest.pathVariable(ID_PATH_PARAM).toLong()

                    return@flatMap ServerResponse.ok()
                            .body(personService.update(body))
                }

    fun delete(serverRequest: ServerRequest) : Mono<ServerResponse> {
        log.debug("delete user by id = {}", serverRequest.pathVariable(ID_PATH_PARAM))

        return ServerResponse.ok()
                    .body(personService
                            .delete(Person(serverRequest.pathVariable(ID_PATH_PARAM).toLong())))
    }

    fun findById(serverRequest: ServerRequest) : Mono<ServerResponse> {
        log.debug("find user by id = {}", serverRequest.pathVariable(ID_PATH_PARAM))

        return ServerResponse.ok()
                    .body(personService
                            .findById(serverRequest.pathVariable(ID_PATH_PARAM).toLong()))
    }
}