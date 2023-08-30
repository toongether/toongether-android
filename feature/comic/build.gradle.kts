plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.comic"
}

dependencies {
    implementation(libs.glide.compose)
    implementation(libs.kotlinx.datetime)
}
