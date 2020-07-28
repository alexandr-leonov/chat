package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

data class Message(@Id
                   @JsonProperty("message_id")
                   var messageId: Long? = 0,
                   @JsonProperty("person_id")
                   var personId: Long? = 0,
                   @JsonProperty("dialog_id")
                   var dialogId: Long? = 0,
                   var text: String? = null,
                   var creationDate: LocalDateTime? = null,
                   var whoReads: List<Long>? = Collections.emptyList()) {
    // for bean creation
    constructor(): this(0, 0, 0, null, null, Collections.emptyList())
}