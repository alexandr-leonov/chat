package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class Person(@Id
                  @JsonProperty("person_id")
                  val personId: Long,
                  val username: String,
                  val password: String,
                  val name: String) {
    // for bean creation
    constructor(): this(0, "", "", "")
}