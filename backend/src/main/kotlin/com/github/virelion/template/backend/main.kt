package com.github.virelion.template.backend

import com.github.virelion.template.Question
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.collections.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

fun main() {
    val json = Json {
        prettyPrint = true
    }
    val questions = ConcurrentList<Question>()
    questions.add(Question("TestQuestion"))
    val server = embeddedServer(Netty, 8080) {
        install(CORS) {
            method(HttpMethod.Options)
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Put)
            method(HttpMethod.Delete)
            method(HttpMethod.Patch)
            anyHost()
            header(HttpHeaders.AccessControlAllowHeaders)
            header(HttpHeaders.ContentType)
            header(HttpHeaders.AccessControlAllowOrigin)
        }
        routing {
            get("/questions") {
                call.respondText(json.encodeToString(ListSerializer(Question.serializer()), questions), ContentType.Application.Json)
            }
            post("/questions") {
                val newQuestion = json.decodeFromString(Question.serializer(), call.receiveText())
                questions.add(newQuestion)
                call.respondText("")
            }
        }
    }
    server.start(wait = true)
}

