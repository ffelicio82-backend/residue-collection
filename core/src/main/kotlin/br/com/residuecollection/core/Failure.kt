package br.com.residuecollection.core

sealed class Failure {
    data class LoginFailure(val message: String? = null) : Failure()
    data class UnknownFailure(val message: String? = null) : Failure()
}