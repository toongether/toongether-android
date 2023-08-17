plugins {
    id("toongether.android.application")
    id("toongether.android.application.compose")
    id("toongether.android.hilt")
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

    implementation(project(":core:designsystem"))
    implementation(project(":feature:home"))
    implementation(project(":feature:series"))
    implementation(project(":feature:shorts"))
    implementation(project(":feature:community"))
    implementation(project(":feature:my"))
    implementation(project(":feature:comic"))
    implementation(project(":feature:auth:login"))
    implementation(project(":feature:auth:signup"))
}
