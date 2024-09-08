package br.com.residuecollection.di

import br.com.residuecollection.domain.repository.auth.AuthRepository
import br.com.residuecollection.domain.usecase.auth.LoginUseCase
import br.com.residuecollection.features.auth.controller.LoginController
import org.koin.dsl.module

val authModule = module {
    factory<LoginUseCase> { LoginUseCase(authRepository = get<AuthRepository>()) }
    factory<LoginController> { LoginController(loginUseCase = get<LoginUseCase>()) }
}