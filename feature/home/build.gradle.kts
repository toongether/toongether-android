plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.home"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":feature:comic"))
    implementation(project(":feature:episode"))
    implementation(libs.coil.compose)
    implementation(libs.lottie.compose)
}
