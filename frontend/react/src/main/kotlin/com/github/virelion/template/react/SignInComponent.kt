package com.github.virelion.template.react

import com.github.virelion.template.AuthenticationData
import com.github.virelion.template.frontend.coreImpl
import com.github.virelion.template.frontend.presenters.SignInPresenter
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*

interface SignInState : RState {
    var identifier: String
    var password: String

    var errorMessage: String?
}

class SignInComponent: RComponent<RProps, SignInState>(), SignInPresenter.View {
    private val presenter = SignInPresenter(this, coreImpl)

    init {
        state.identifier = ""
        state.password = ""
        state.errorMessage = null
    }

    override fun RBuilder.render() {
        div {
            h1 {
                +"SignIn"
            }
            state.errorMessage?.let {
                p {
                    +it
                }
            }
            input {
                attrs {
                    this.placeholder = "Identifier"
                    this.value = state.identifier
                    this.onChangeFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            identifier = target.value
                        }
                    }
                }
            }
            input {
                attrs {
                    this.placeholder = "Password"
                    this.value = state.password
                    this.onChangeFunction = {
                        val target = it.target as HTMLInputElement
                        setState {
                            password = target.value
                        }
                    }
                }
            }
            button {
                +"Sign in"
                attrs {
                    this.onClickFunction = {
                        presenter.signIn(AuthenticationData(state.identifier, state.password))
                    }
                }
            }
        }
    }

    override fun authenticationFailed(errorMessage: String?) {
        setState {
            this.errorMessage = errorMessage
        }
    }
}