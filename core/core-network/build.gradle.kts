plugins {
    id("cinemania.convention.android.library")
}

android.namespace = "com.dantrap.cinemania.fintech.core.network"

dependencies {
    implementation(libs.bundles.network)
    implementation(libs.annotation)
    implementation(libs.koin.core)
}
