package com.github.virelion.template.frontend.utils

class Listener<T> {
    private val subscribers: MutableMap<String, (T) -> Unit> = mutableMapOf()

    fun notifyAll(value: T) {
        subscribers.forEach { it.value.invoke(value) }
    }

    fun subscribe(tag: String, block: (T) -> Unit) {
        subscribers[tag] = block
    }
}