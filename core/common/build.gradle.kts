plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
}

android {
    namespace = "kr.toongether.common"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.kotlinx.datetime)
}
