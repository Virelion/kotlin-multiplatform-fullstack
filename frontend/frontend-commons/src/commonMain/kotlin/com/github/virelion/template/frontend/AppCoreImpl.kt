package com.github.virelion.template.frontend

import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.frontend.utils.Listener

val coreImpl = AppCoreImpl()

class AppCoreImpl : AppCore {
    override var authenticationDataResponse: AuthenticationDataResponse? = null
        set(value) {
            authenticationListener.notifyAll(value)
        }
    override val authenticationListener: Listener<AuthenticationDataResponse?> = Listener()
}