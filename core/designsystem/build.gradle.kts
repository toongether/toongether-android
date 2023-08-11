plugins {
    id("toongether.android.library")
    id("toongether.android.library.compose")
}

android {
    namespace = "kr.toongether.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.androidx.constraint.layout.compose)
}
