package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

data class Message(@Id
                   @JsonProperty("message_id")
                   val messageId: Long,
                   @JsonProperty("person_id")
                   val personId: Long,
                   @JsonProperty("dialog_id")
                   val dialogId: Long,
                   val text: String,
                   val creationDate: LocalDateTime,
                   val whoReads: List<Long>) {
    // for bean creation
    constructor(): this(0, 0, 0, "", LocalDateTime.now(), Collections.emptyList())
}