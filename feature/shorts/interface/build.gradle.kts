plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.shorts"
}

dependencies {

    implementation(project(":core:designsystem"))

    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.compose)
}
