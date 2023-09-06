plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.episode"
}

dependencies {
    implementation(project(":feature:comic"))
    implementation(project(":core:common"))
    implementation(project(":core:ui"))

    implementation(libs.androidx.paging.compose)
    implementation(libs.coil.compose)
}
