package com.github.virelion.template.frontend

import com.github.virelion.template.AuthenticationData
import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.frontend.utils.Listener
import io.ktor.client.*
import kotlinx.serialization.json.Json

interface AppCore {
    var authenticationDataResponse: AuthenticationDataResponse?
    val authenticationListener: Listener<AuthenticationDataResponse?>
    val httpClient: HttpClient
    val json: Json
}