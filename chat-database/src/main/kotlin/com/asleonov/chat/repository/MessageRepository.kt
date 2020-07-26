package com.asleonov.chat.repository

import com.asleonov.chat.entity.Message
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : ReactiveCrudRepository<Message, Long>