package com.asleonov.chat.repository

import com.asleonov.chat.entity.Dialog
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DialogRepository : ReactiveCrudRepository<Dialog, Long> {
}