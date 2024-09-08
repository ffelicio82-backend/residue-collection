plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "br.com.residuecollection.core"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.jupiter.test)
}

tasks.test {
    useJUnitPlatform()
}