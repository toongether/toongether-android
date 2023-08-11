plugins {
    id("toongether.android.library")
    id("toongether.android.library.compose")
}

android {
    namespace = "kr.toongether.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.glide.compose)
    implementation(libs.androidx.compose.material)
}