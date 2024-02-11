plugins {
    id("cinemania.convention.android.application")
    id("cinemania.convention.android.compose")
    id("cinemania.convention.apikey.provider")
}

android {
    namespace = "com.dantrap.cinemania.fintech"
    defaultConfig.applicationId = "com.dantrap.cinemania.fintech"
    buildFeatures.buildConfig = true
}

dependencies {
    implementation(project(":core:core-ui"))
    implementation(project(":core:core-data"))
    implementation(project(":core:core-common"))
    implementation(project(":core:core-network"))
    implementation(project(":core:core-mvi"))
    implementation(project(":core:core-domain"))
    implementation(project(":features:feature-home"))
    implementation(project(":features:feature-settings"))
    implementation(project(":features:feature-details"))

    implementation(libs.activity.compose)

    implementation(libs.compose.navigation)

    implementation(libs.bundles.compose)

    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.material.icons.extended)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.orbit.viewmodel)
    implementation(libs.orbit.compose)
}
