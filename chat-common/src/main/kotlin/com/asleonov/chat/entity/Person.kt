package com.asleonov.chat.entity

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

@JsonInclude(value = JsonInclude.Include.NON_NULL)
data class Person(@Id
                  @JsonProperty("person_id")
                  var personId: Long? = null,
                  var username: String? = null,
                  var password: String? = null,
                  var name: String? = null) {
    // for bean creation
    constructor(): this(null, null, null, null)
}