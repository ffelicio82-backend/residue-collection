package br.com.residuecollection.features.auth.controller

import br.com.residuecollection.core.fold
import br.com.residuecollection.domain.usecase.auth.LoginUseCase
import br.com.residuecollection.domain.usecase.auth.LoginUseCase.LoginRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

class LoginController(private val loginUseCase: LoginUseCase) {
    suspend fun login(call: ApplicationCall) {
        loginUseCase
            .execute(request = LoginRequest(email = "test@test.com", password = "password"))
            .fold(
                leftOperation = {
                    error -> call.respondText(status = HttpStatusCode.InternalServerError, text = error)
                },
                rightOperation = {
                    value -> call.respondText(status = HttpStatusCode.OK, text = value)
                }
            )
    }
}