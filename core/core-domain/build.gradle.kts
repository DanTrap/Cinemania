plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    api(project(":core:core-common"))
    implementation(libs.coroutines.core)
    implementation(libs.koin.core)
    implementation(libs.paging.common)
}
