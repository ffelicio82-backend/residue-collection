package br.com.residuecollection.domain.repository.auth

import br.com.residuecollection.core.Either

interface AuthRepository {
    suspend fun login(email : String, password : String) : Either<String, String>
    suspend fun logout(jwt: String)
}