package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*


data class Dialog(@Id
                  @JsonProperty("dialog_id")
                  var dialogId: Long? = null,
                  var name: String? = null,
                  @JsonProperty("last_used_date")
                  var lastUsedDate: LocalDateTime? = null,
                  @JsonProperty("person_ids")
                  var personIds: List<Long>? = Collections.emptyList()) {
    // for bean creation
    constructor(): this(null, null, null, Collections.emptyList())
}