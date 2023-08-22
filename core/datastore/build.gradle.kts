plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.hs.dgsw.smartschool.datastore"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidx.dataStore.core)
    implementation(libs.kotlinx.coroutines.android)
}