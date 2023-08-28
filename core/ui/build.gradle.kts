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
    implementation(project(":core:common"))

    implementation(libs.glide.compose)
    implementation(libs.kotlinx.datetime)
}
