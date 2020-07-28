package com.asleonov.chat.handler

import com.asleonov.chat.dto.CreateMessageRequest
import com.asleonov.chat.entity.Person
import com.asleonov.chat.service.MessageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class MessageHandler(val messageService: MessageService) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    companion object {
        const val ID_PATH_PARAM: String = "id"
    }

    fun findAll(serverRequest: ServerRequest): Mono<ServerResponse> {
        log.debug("find all messages")
        return ServerResponse.ok()
                .body(messageService
                        .findAll()
                        .collectList())
    }

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> = serverRequest.bodyToMono(CreateMessageRequest::class.java)
            .flatMap { body ->
                log.debug("create message by params {}", body)

                return@flatMap ServerResponse
                        .ok()
                        .body(messageService.create(body))
            }

    fun findById(serverRequest: ServerRequest) : Mono<ServerResponse> {
        log.debug("find message by id = {}", serverRequest.pathVariable(PersonHandler.ID_PATH_PARAM))

        return ServerResponse.ok()
                .body(messageService
                        .findById(serverRequest.pathVariable(PersonHandler.ID_PATH_PARAM).toLong()))
    }


}