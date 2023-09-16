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

    implementation(libs.kotlinx.datetime)
    implementation(libs.androidx.paging.compose)
    implementation(libs.coil.compose)
}
