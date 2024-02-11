@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Cinemania"

include(":app")
include(":core:core-ui")
include(":core:core-domain")
include(":core:core-data")
include(":core:core-network")
include(":core:core-common")
include(":core:core-mvi")
include(":features:feature-home")
include(":features:feature-settings")
include(":features:feature-details")
