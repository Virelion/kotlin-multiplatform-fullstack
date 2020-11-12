package com.github.virelion.template

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val content: String,
)