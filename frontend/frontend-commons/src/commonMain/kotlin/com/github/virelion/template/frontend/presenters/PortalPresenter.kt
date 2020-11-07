package com.github.virelion.template.frontend.presenters

import com.github.virelion.template.frontend.AppCore
import com.github.virelion.template.frontend.coreImpl

class PortalPresenter(
    private val appCore: AppCore = coreImpl
) {
    fun signOut() {
        appCore.authenticationDataResponse = null
    }
}