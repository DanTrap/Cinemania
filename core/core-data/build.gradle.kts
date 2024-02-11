plugins {
    id("cinemania.convention.android.library")
}

android.namespace = "com.dantrap.cinemania.fintech.core.data"

dependencies {
    implementation(project(":core:core-domain"))
    implementation(project(":core:core-network"))
    implementation(project(":core:core-common"))
    implementation(project(":core:core-database"))

    implementation(libs.appcompat)

    implementation(libs.bundles.network)

    implementation(libs.koin.android)

    implementation(libs.datastore.preferences)

    implementation(libs.paging.common)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}
