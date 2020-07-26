package com.asleonov.chat.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Message(@Id val messageId: Long,
                   val personId: Long,
                   val dialogId: Long,
                   val text: String,
                   val creationDate: LocalDateTime,
                   val whoReads: List<Long>)