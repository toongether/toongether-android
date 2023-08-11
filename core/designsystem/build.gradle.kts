plugins {
    id("toongether.android.library")
    id("toongether.android.library.compose")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.constraint.layout.compose)
}
