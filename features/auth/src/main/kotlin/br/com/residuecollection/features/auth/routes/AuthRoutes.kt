package br.com.residuecollection.features.auth.routes

import br.com.residuecollection.domain.usecase.auth.LoginUseCase
import br.com.residuecollection.features.auth.controller.LoginController
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.authRoutes() {
    val loginUseCase by inject<LoginUseCase>()

    route("/auth") {
        get("/login") {
            LoginController(loginUseCase = loginUseCase).login(call = call)
        }

        get("/logout") {
            call.respondText(text = "logout")
        }
    }
}