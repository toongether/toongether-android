plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.comic"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.paging.compose)
}
