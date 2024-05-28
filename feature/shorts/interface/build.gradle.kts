plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.shorts"
}

dependencies {

    implementation(project(":core:designsystem"))

    implementation("com.github.nanihadesuka:LazyColumnScrollbar:2.1.0")
    implementation(libs.lottie.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.compose)
}
