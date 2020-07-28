package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

data class Message(@Id
                   @JsonProperty("message_id")
                   var messageId: Long? = null,
                   @JsonProperty("person_id")
                   var personId: Long? = null,
                   @JsonProperty("dialog_id")
                   var dialogId: Long? = null,
                   var text: String? = null,
                   @JsonProperty("creation_date")
                   var creationDate: LocalDateTime? = null,
                   @JsonProperty("who_reads")
                   var whoReads: List<Long>? = Collections.emptyList()) {
    // for bean creation
    constructor(): this(null, null, null, null, null, Collections.emptyList())
}