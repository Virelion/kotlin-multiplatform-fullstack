package com.github.virelion.template.frontend

import com.github.virelion.template.AuthenticationData
import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.frontend.utils.Listener

interface AppCore {
    var authenticationDataResponse: AuthenticationDataResponse?
    val authenticationListener: Listener<AuthenticationDataResponse?>
}