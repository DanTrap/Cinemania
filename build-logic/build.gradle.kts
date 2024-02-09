plugins {
    `kotlin-dsl`
}

group = "com.dantrap.cinemania.fintech.buildlogic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "cinemania.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidComposeApplication") {
            id = "cinemania.convention.android.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "cinemania.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "cinemania.convention.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("apiKeyProvider") {
            id = "cinemania.convention.apikey.provider"
            implementationClass = "ApiKeyProviderConventionPlugin"
        }
        register("detekt") {
            id = "cinemania.detekt"
            implementationClass = "DetektConventionPlugin"
        }
    }
}
