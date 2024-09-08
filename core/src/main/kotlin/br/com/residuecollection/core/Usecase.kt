package br.com.residuecollection.core

import br.com.residuecollection.core.Usecase.Request

abstract class Usecase<RESULT, REQUEST : Request> {
    abstract suspend fun execute(request: REQUEST) : Either<String, RESULT>
    abstract class Request
}