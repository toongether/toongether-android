plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "kr.toongether.network"
}

dependencies {

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.datetime)
    implementation(project(":core:common"))
    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
}
