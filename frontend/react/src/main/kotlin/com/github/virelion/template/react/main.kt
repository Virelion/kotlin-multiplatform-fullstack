package com.github.virelion.template.react

import kotlinx.browser.document
import react.dom.*

fun main() {
    val root = document.getElementById("root")
    render(root, callback = {}) {
        child(MainComponent::class) {}
    }
}