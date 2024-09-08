plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "br.com.residuecollection"
include("domain")
include("app")
include("data")
include("features:auth")
findProject(":features:auth")?.name = "auth"
include("core")
