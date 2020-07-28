package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*


data class Dialog(@Id
                  @JsonProperty("dialog_id")
                  var dialogId: Long? = 0,
                  var name: String? = null,
                  var lastUsedDate: LocalDateTime? = null,
                  var countUnreadMessages: Int? = 0,
                  var personIds: List<Long>? = Collections.emptyList()) {
    // for bean creation
    constructor(): this(0, null, null,0, Collections.emptyList())
}