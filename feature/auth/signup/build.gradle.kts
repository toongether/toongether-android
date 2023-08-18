plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.signup"
}

dependencies {
    implementation(libs.androidx.compose.material.icons)
    implementation(project(":core:common"))
}
