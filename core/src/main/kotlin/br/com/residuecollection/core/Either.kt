package br.com.residuecollection.core

sealed class Either<out L : Failure, out R> {
    data class Left<out L : Failure>(val failure: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()
}

inline fun <L : Failure, R, T> Either<L, R>.fold(
    leftOperation: (L) -> T,
    rightOperation: (R) -> T
): T = when (this) {
    is Either.Left -> leftOperation(failure)
    is Either.Right -> rightOperation(value)
}