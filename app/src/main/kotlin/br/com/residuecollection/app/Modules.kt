package br.com.residuecollection.app

import br.com.residuecollection.br.com.residuecollection.di.dataModule
import br.com.residuecollection.di.authModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.core.logger.Level
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureModules() {
    install(Koin) {
        slf4jLogger(level = Level.INFO)

        modules(
            listOf(
                dataModule,
                authModule
            )
        )
    }
}