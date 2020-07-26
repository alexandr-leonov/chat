package com.asleonov.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
class ChatApplication

fun main(args: Array<String>) {
	runApplication<ChatApplication>(*args)
}
