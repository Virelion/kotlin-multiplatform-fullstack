package com.github.virelion.template.react

import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.frontend.AppCore
import com.github.virelion.template.frontend.coreImpl
import react.*
import react.dom.div

interface AuthState: RState {
    var authenticationDataResponse: AuthenticationDataResponse?
}

class MainComponent: RComponent<RProps, AuthState>() {
    private val appCore: AppCore

    init {
        appCore = coreImpl
        state.authenticationDataResponse = AuthenticationDataResponse("", "guest")

        appCore.authenticationListener.subscribe("MainComponent") {
            setState {
                authenticationDataResponse = it
            }
        }
    }

    override fun RBuilder.render() {
        div {
            val authenticationDataResponse = state.authenticationDataResponse
            if(authenticationDataResponse != null) {
                child(PortalComponent::class) {
                    this.attrs.userName = authenticationDataResponse.name
                }
            } else {
                child(SignInComponent::class) { }
            }
        }
    }
}