package br.com.residuecollection.domain.usecase.auth

import br.com.residuecollection.core.Either
import br.com.residuecollection.core.Failure
import br.com.residuecollection.core.Failure.LoginFailure
import br.com.residuecollection.domain.repository.auth.AuthRepository
import br.com.residuecollection.domain.usecase.auth.LoginUseCase.LoginParams
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginUsecaseTest {
    private var authRepository : AuthRepository = mockk<AuthRepository>()
    private lateinit var loginUseCase : LoginUseCase

    val params : LoginParams = LoginParams(email = "test@example.com", password = "password123")

    @BeforeEach
    fun setUp() {
        loginUseCase = LoginUseCase(authRepository = authRepository)
    }

    @Test
    fun `should return success when authentication process occurs with success`() = runBlocking {
        // arrange
        val successResponse : Either.Right<String> = Either.Right("UserToken123")
        coEvery {
            authRepository.login(email = params.email, password = params.password)
        } returns successResponse

        // act
        val result : Either<Failure, String> = loginUseCase.execute(params = params)

        // assert
        assertEquals(successResponse, result)
        coVerify { authRepository.login(email = params.email, password = params.password) }
    }

    @Test
    fun `should return LoginFailure when login fails`() = runBlocking {
        // arrange
        val failureResponse : Either.Left<LoginFailure> = Either.Left(failure = LoginFailure())
        coEvery {
            authRepository.login(email = params.email, password = params.password)
        } returns failureResponse

        // act
        val result : Either<Failure, String> = loginUseCase.execute(params = params)

        // assert
        assertEquals(failureResponse, result)
        coVerify { authRepository.login(email = params.email, password = params.password) }
    }
}