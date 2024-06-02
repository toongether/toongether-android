plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.shorts"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":feature:shorts:interface"))
    implementation(libs.androidx.paging.compose)
    implementation(libs.kotlinx.datetime)
}
