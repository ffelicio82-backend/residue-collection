package br.com.residuecollection.app

import br.com.residuecollection.features.auth.routes.authRoutes
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRoutes() {
    routing {
        authRoutes()
    }
}