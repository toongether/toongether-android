plugins {
    id("toongether.android.application")
    id("toongether.android.application.compose")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.toongether.shorts.demo"

    defaultConfig {
        applicationId = "kr.toongether.shorts.demo"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":feature:shorts:source"))
}
