package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class Person(@Id
                  @JsonProperty("person_id")
                  var personId: Long? = 0,
                  var username: String? = null,
                  var password: String? = null,
                  var name: String? = null) {
    // for bean creation
    constructor(): this(0, null, null, null)

    constructor(id: Long): this(id, null, null, null)
}