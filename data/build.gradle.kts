plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "br.com.residuecollection.data"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(libs.koin.ktor)
    testImplementation(libs.kotlin.test.junit)
}

tasks.test {
    useJUnitPlatform()
}