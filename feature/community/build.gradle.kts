plugins {
    id("toongether.android.library")
    id("toongether.android.library.compose")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.community"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(project(":core:designsystem"))
}
