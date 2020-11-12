package com.github.virelion.template.react

import com.github.virelion.template.AuthenticationData
import com.github.virelion.template.Question
import com.github.virelion.template.frontend.presenters.QuestionsPresenter
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.button
import react.dom.div
import react.dom.input

interface QuestionsComponentState: RState {
    var questions: List<Question>
    var newQuestion: String
}

class QuestionsComponent: RComponent<RProps, QuestionsComponentState>(), QuestionsPresenter.View {
    private val presenter = QuestionsPresenter(this)

    override var questions: List<Question>
        get() = state.questions
        set(value) {
            setState {
                questions = value
            }
        }
    override var newQuestion: String
        get() = state.newQuestion
        set(value) {
            setState {
                newQuestion = value
            }
        }

    init {
        state.questions = listOf()
        state.newQuestion = ""
    }

    override fun componentDidMount() {
        presenter.refresh()
    }

    override fun RBuilder.render() {
        div {
            div {
                input {
                    attrs {
                        this.placeholder = "Type in question-"
                        this.value = state.newQuestion
                        this.onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState {
                                newQuestion = target.value
                            }
                        }
                    }
                }
                button {
                    +"Publish"
                    attrs {
                        this.onClickFunction = {
                            presenter.publish()
                        }
                    }
                }
            }
            state.questions.forEach {
                div {
                    +it.content
                }
            }
        }
    }
}