package com.asleonov.chat.service.impl

import com.asleonov.chat.entity.Dialog
import com.asleonov.chat.repository.DialogRepository
import com.asleonov.chat.service.CrudService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DialogServiceImpl(val dialogRepository: DialogRepository) : CrudService<Dialog> {
    override fun findAll(): Flux<Dialog> = dialogRepository.findAll()

    override fun update(dialog: Dialog): Mono<Dialog> = dialogRepository.save(dialog)

    override fun delete(dialog: Dialog): Mono<Dialog> = dialogRepository.deleteById(dialog.dialogId).thenReturn(dialog)

    override fun deleteAll(): Mono<Void> = dialogRepository.deleteAll()

    override fun find(t: Dialog): Mono<Dialog> = dialogRepository.findById(t.dialogId)

}