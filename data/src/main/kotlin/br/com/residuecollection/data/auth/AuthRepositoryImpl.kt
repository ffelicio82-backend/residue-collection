package br.com.residuecollection.data.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.core.Failure
import br.com.residuecollection.domain.repository.auth.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String) : Either<Failure, String> {
        return Either.Right(value = "email = $email | password = $password -> vindo do repository (módulo data com Either)")
    }

    override suspend fun logout(jwt: String) : Either<Failure, Boolean> {
        return Either.Right<Boolean>(value = true)
    }
}