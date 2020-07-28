package com.asleonov.chat.service

import com.asleonov.chat.dto.CreateMessageRequest
import com.asleonov.chat.entity.Message
import com.asleonov.chat.facade.CrudFacade
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.util.*

@Service
class MessageService(val messageFacade: CrudFacade<Message>) {

    fun findAll() : Flux<Message> = messageFacade.findAll()

    fun findById(id: Long) : Mono<Message> = messageFacade.find(Message(id))

    fun create(body: CreateMessageRequest): Mono<Message> {
        val message = Message()
        message.personId = body.authorId
        message.dialogId = body.dialogId
        message.text = body.text
        message.creationDate = LocalDateTime.now()
        message.whoReads = Collections.singletonList(body.authorId)

        return messageFacade.update(message)
    }

}