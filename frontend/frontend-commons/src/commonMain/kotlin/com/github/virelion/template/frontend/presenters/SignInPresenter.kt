package com.github.virelion.template.frontend.presenters

import com.github.virelion.template.AuthenticationDataResponse
import com.github.virelion.template.AuthenticationData
import com.github.virelion.template.frontend.AppCore
import com.github.virelion.template.frontend.coreImpl

class SignInPresenter(
        private val view: View,
        private val appCore: AppCore = coreImpl
) {
    interface View {
        fun authenticationFailed(errorMessage: String?)
    }

    fun signIn(authenticationData: AuthenticationData) {
        if(authenticationData.password == "123456") {
            val response = AuthenticationDataResponse("", authenticationData.identifier)
            appCore.authenticationDataResponse = response
            view.authenticationFailed(null)
        } else {
            view.authenticationFailed("Nope")
        }
    }

}