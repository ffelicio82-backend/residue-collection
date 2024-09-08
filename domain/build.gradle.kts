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

    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.mockk.test)
}

tasks.test {
    useJUnitPlatform()
}