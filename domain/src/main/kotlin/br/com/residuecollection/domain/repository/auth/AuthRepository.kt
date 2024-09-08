package br.com.residuecollection.domain.repository.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.core.Failure

interface AuthRepository {
    suspend fun login(email : String, password : String) : Either<Failure, String>
    suspend fun logout(jwt: String) : Either<Failure, Boolean>
}