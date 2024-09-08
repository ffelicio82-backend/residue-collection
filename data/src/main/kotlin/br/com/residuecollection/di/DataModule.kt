package br.com.residuecollection.br.com.residuecollection.di

import br.com.residuecollection.br.com.residuecollection.data.auth.AuthRepositoryImpl
import br.com.residuecollection.domain.repository.auth.AuthRepository
import org.koin.dsl.module

val dataModule = module {
    single<AuthRepository> { AuthRepositoryImpl() }
}