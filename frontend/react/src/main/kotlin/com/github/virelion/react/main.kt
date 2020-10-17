package com.github.virelion.react

import kotlinx.browser.document
import react.dom.*

fun main() {
    val root = document.getElementById("root")
    val component = MainComponent()
    render(root, callback = {}) {
        child(MainComponent::class) {

        }
    }
}