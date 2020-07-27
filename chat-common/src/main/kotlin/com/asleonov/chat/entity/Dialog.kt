package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*


data class Dialog(@Id
                  @JsonProperty("dialog_id")
                  val dialogId: Long,
                  val name: String,
                  val lastUsedDate: LocalDateTime,
                  val countUnreadMessages: Int,
                  val personIds: List<Long>) {
    // for bean creation
    constructor(): this(0, "", LocalDateTime.now(),0, Collections.emptyList())
}