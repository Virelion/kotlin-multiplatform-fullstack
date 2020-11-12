package com.github.virelion.template.frontend

import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.frontend.utils.Listener
import io.ktor.client.*
import io.ktor.client.features.*
import kotlinx.serialization.json.Json

val coreImpl = AppCoreImpl()

class AppCoreImpl : AppCore {
    override var authenticationDataResponse: AuthenticationDataResponse? = null
        set(value) {
            authenticationListener.notifyAll(value)
        }
    override val authenticationListener: Listener<AuthenticationDataResponse?> = Listener()

    override val httpClient = HttpClient {
        defaultRequest {
            url {
                this.host = "localhost"
                this.port = 8080
            }
        }
    }
    override val json: Json = Json {
        prettyPrint = true
    }
}