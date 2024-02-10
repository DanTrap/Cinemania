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
    implementation(project(":core:core-domain"))

    implementation(libs.bundles.compose)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.lottie.compose)

    implementation(libs.paging.common)

    implementation(libs.coil.compose)
}
