package br.com.residuecollection.br.com.residuecollection.data.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.domain.repository.auth.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String) : Either<String, String> {
        return Either.Right("email = $email | password = $password -> vindo do repository (módulo data com Either)")
    }

    override suspend fun logout(jwt: String) {
        TODO("Not yet implemented")
    }
}