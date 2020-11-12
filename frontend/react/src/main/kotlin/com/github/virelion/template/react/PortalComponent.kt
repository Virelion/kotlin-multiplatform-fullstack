package com.github.virelion.template.react

import com.github.virelion.template.frontend.presenters.PortalPresenter
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.h1

interface PortalProps: RProps {
    var userName: String
}

class PortalComponent : RComponent<PortalProps, RState>(){
    val presenter = PortalPresenter()


    override fun RBuilder.render() {
        div {
            button {
                +"Sign out"
                attrs {
                    onClickFunction = {
                        presenter.signOut()
                    }
                }
            }
            child(QuestionsComponent::class) { }
        }
    }

}