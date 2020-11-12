package com.github.virelion.template.frontend.presenters

import com.github.virelion.template.frontend.AppCore
import com.github.virelion.template.frontend.coreImpl

class AddQuestionPresenter(
    private val view: AddQuestionPresenter.View,
    private val appCore: AppCore = coreImpl
) {
    interface View {
        var content: String
    }
}