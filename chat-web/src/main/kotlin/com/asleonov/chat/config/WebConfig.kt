package com.asleonov.chat.config

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
            .PUT("/persons/{id}", personHandler::update)
            .DELETE("/persons/{id}", personHandler::delete)
            .build()



}