plugins {
    id("cinemania.convention.android.library")
    id("cinemania.convention.android.library.compose")
}

android {
    namespace = "com.dantrap.cinemania.fintech.core.ui"
    defaultConfig.resourceConfigurations += listOf("en")
}

dependencies {
    implementation(project(":core:core-common"))

    implementation(libs.bundles.compose)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.lottie.compose)
}
