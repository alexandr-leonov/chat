package com.asleonov.chat.config

import com.asleonov.chat.handler.MessageHandler
import com.asleonov.chat.handler.PersonHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@EnableWebFlux
@Configuration
class WebConfig {

    @Bean
    fun personRoute(personHandler: PersonHandler) : RouterFunction<ServerResponse> = RouterFunctions
            .route()
            .GET("/persons", personHandler::findAll)
            .POST("/persons", personHandler::create)
            .GET("/persons/{id}", personHandler::findById)
            .PUT("/persons/{id}", personHandler::update)
            .DELETE("/persons/{id}", personHandler::delete)
            .build()


    @Bean
    fun messageRoute(messageHandler: MessageHandler) : RouterFunction<ServerResponse> = RouterFunctions
            .route()
            .GET("/messages", messageHandler::findAll)
            .POST("/messages", messageHandler::create)
            .GET("/messages/{id}", messageHandler::findById)
            .build()

}