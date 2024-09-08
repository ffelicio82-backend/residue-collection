package br.com.residuecollection.core

import br.com.residuecollection.core.Usecase.Params

abstract class Usecase<R, P : Params> {
    abstract suspend fun execute(params : P) : Either<Failure, R>
    abstract class Params
}