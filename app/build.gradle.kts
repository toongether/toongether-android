plugins {
    id("toongether.android.application")
    id("toongether.android.application.compose")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.android"

    defaultConfig {
        applicationId = "kr.toongether.android"
        versionCode = 1
        versionName = "0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui.util)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.navigation.animation)
    debugImplementation(libs.androidx.compose.ui.testManifest)

    implementation(project(":core:designsystem"))
    implementation(project(":feature:home"))
    implementation(project(":feature:series"))
    implementation(project(":feature:shorts"))
    implementation(project(":feature:community"))
    implementation(project(":feature:my"))
    implementation(project(":feature:comic"))
}
