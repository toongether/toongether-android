plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.home"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":feature:comic:interface"))
    implementation(project(":feature:episode:interface"))
    implementation(project(":feature:home:interface"))
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.paging.compose)
}
