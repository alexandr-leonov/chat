package com.asleonov.chat.facade.impl

import com.asleonov.chat.entity.Message
import com.asleonov.chat.repository.MessageRepository
import com.asleonov.chat.facade.CrudFacade
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class MessageFacadeImpl(val messageRepository: MessageRepository) : CrudFacade<Message> {
    override fun findAll(): Flux<Message> = messageRepository.findAll()

    override fun update(message: Message): Mono<Message> = messageRepository.save(message)

    override fun delete(message: Message): Mono<Message> = messageRepository.deleteById(message.messageId!!).thenReturn(message)

    override fun deleteAll(): Mono<Void> = messageRepository.deleteAll()

    override fun find(t: Message): Mono<Message> = messageRepository.findById(t.messageId!!)
}