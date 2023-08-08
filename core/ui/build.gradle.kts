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

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.material3)
    implementation(libs.glide.compose)
    implementation(libs.androidx.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}