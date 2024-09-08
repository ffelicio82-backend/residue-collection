package br.com.residuecollection.domain.usecase.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.core.Failure
import br.com.residuecollection.core.Usecase
import br.com.residuecollection.domain.repository.auth.AuthRepository
import br.com.residuecollection.domain.usecase.auth.LoginUseCase.LoginParams

class LoginUseCase(private val authRepository: AuthRepository) : Usecase<String, LoginParams>() {
    override suspend fun execute(params: LoginParams) : Either<Failure, String> {
        return authRepository.login(email = params.email, password = params.password)
    }

    data class LoginParams(val email : String, val password : String) : Params()
}