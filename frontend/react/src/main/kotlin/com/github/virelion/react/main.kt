package com.github.virelion.react

import kotlinx.browser.document
import react.*
import react.dom.*

fun main() {
    val root = document.getElementById("root")
    render(root, callback = {}) {
        app()
    }
}

fun RBuilder.app() {
    div {
        p {
            +"Hello world"
        }
    }
}