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

    implementation(libs.androidx.paging.compose)
}
