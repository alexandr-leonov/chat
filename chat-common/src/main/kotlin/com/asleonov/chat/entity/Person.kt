package com.asleonov.chat.entity

import org.springframework.data.annotation.Id

data class Person(@Id val personId: Long,
                  val username: String,
                  val password: String,
                  val name: String)