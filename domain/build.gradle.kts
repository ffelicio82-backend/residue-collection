plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "br.com.residuecollection.domain"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))

    implementation(libs.kotlin.coroutines)

    testImplementation(libs.jupiter.test)
    testImplementation(libs.mockk.test)
}

tasks.test {
    useJUnitPlatform()
}