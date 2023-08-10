plugins {
    id("toongether.android.library")
    id("toongether.android.hilt")
    id("toongether.kotlin.code")
}

android {
    namespace = "kr.toongether.network"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.gson.converter)
}
