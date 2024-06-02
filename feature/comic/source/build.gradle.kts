plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.comic"
}

dependencies {
    implementation(project(":feature:comic:interface"))
    implementation(project(":core:common"))
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.datetime)
}
