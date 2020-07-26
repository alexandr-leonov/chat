package com.asleonov.chat.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime


data class Dialog(@Id val dialogId: Long,
                  val name: String,
                  val lastUsedDate: LocalDateTime,
                  val countUnreadMessages: Int,
                  val personIds: List<Long>) {
}