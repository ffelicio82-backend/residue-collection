plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
}

group = "br.com.residuecollection.features.auth"
version = "0.0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.koin.ktor)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.jupiter.test)
    testImplementation(libs.koin.test)
    testImplementation(libs.mockk.test)
}

tasks.test {
    useJUnitPlatform()
}