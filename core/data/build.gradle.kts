plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":core:model"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}
