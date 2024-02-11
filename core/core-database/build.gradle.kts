plugins {
    id("cinemania.convention.android.library")
    alias(libs.plugins.kotlin.ksp)
}

android.namespace = "com.dantrap.cinemania.fintech.core.database"

dependencies {
    implementation(libs.converter.gson)
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)
    implementation(libs.koin.android)
    implementation(libs.kotlinx.serialization.json)
}
