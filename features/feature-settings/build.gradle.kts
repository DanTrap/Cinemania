plugins {
    id("cinemania.convention.android.library")
    id("cinemania.convention.android.library.compose")
}

android.namespace = "com.dantrap.cinemania.fintech.feature.settings"

dependencies {
    implementation(project(":core:core-ui"))
    implementation(project(":core:core-mvi"))
    implementation(project(":core:core-common"))
    implementation(project(":core:core-domain"))

    implementation(libs.bundles.compose)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.compose.accompanist.webview)

    implementation(libs.material.icons.extended)

    implementation(libs.koin.android)

    implementation(libs.orbit.viewmodel)
}
