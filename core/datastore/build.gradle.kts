plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "kr.toongether.datastore"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.dataStore.core)
    implementation(libs.kotlinx.coroutines.android)
}
