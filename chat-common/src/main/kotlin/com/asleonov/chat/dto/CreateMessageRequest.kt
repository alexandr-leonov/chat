package com.asleonov.chat.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateMessageRequest(@JsonProperty("author_id")
                                val authorId: Long,
                                @JsonProperty("dialog_id")
                                val dialogId: Long,
                                val text: String) {
}