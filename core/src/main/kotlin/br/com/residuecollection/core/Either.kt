package br.com.residuecollection.core

sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()
}

inline fun <L, R, T> Either<L, R>.fold(
    leftOperation: (L) -> T,
    rightOperation: (R) -> T
): T = when (this) {
    is Either.Left -> leftOperation(value)
    is Either.Right -> rightOperation(value)
}