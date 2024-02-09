plugins {
    id("cinemania.convention.android.library")
}

android.namespace = "com.dantrap.cinemania.fintech.core.mvi"

dependencies {
    implementation(libs.orbit.viewmodel)
}
