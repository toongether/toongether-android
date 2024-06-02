plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.main"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":feature:shorts:source"))
    implementation(project(":feature:series:source"))
    implementation(project(":feature:community:source"))
    implementation(project(":feature:archive:source"))
    implementation(project(":feature:my:source"))

    implementation(libs.coil.compose)
    implementation(libs.lottie.compose)
}
