plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.login"
}

dependencies {
    implementation(libs.androidx.compose.material.icons)
}