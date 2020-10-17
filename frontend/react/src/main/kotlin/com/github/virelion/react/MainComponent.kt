package com.github.virelion.react

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button
import react.dom.div

interface GlobalState: RState {
    var authData: AuthData?
}

class MainComponent: RComponent<RProps, GlobalState>() {
    init {
        state.authData = null
    }

    override fun RBuilder.render() {
        div {
            if(state.authData == null) {
                button {
                    +"Sign In"
                    this.attrs.onClickFunction = { setState { authData = AuthData("ABCD", "You") } }
                }
            } else {
                +"Hello ${state.authData?.name}"
            }
        }
    }
}