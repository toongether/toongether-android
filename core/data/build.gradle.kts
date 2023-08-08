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

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
