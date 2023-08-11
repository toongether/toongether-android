plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
    id("kotlinx-serialization")
}

android {
    namespace = "kr.toongether.network"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
