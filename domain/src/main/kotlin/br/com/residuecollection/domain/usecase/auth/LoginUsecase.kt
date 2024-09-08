package br.com.residuecollection.domain.usecase.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.core.Usecase
import br.com.residuecollection.domain.repository.auth.AuthRepository
import br.com.residuecollection.domain.usecase.auth.LoginUseCase.LoginRequest

class LoginUseCase(private val authRepository: AuthRepository) : Usecase<String, LoginRequest>() {
    override suspend fun execute(request: LoginRequest) : Either<String, String> {
        return authRepository.login(email = request.email, password = request.password)
    }

    data class LoginRequest(val email : String, val password : String) : Request()
}