package com.github.virelion.template.frontend.presenters

import com.github.virelion.template.Question
import com.github.virelion.template.frontend.AppCore
import com.github.virelion.template.frontend.coreImpl
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.ListSerializer

class QuestionsPresenter(
    private val view: View,
    private val appCore: AppCore = coreImpl
) {
    interface View {
        var questions: List<Question>
        var newQuestion: String
    }

    fun refresh() {
        GlobalScope.launch {
            reloadList()
        }
    }

    private suspend fun reloadList() {
        val result = appCore.httpClient.get<String>("/questions")
        view.questions = appCore.json.decodeFromString(ListSerializer(Question.serializer()), result)
    }

    fun publish() {
        GlobalScope.launch {
            appCore.httpClient.post<String>("/questions") {
                body = appCore.json.encodeToString(Question.serializer(), Question(view.newQuestion))
                view.newQuestion = ""
            }
            reloadList()
        }
    }
}