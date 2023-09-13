plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.login"
}

dependencies {
    implementation(libs.androidx.compose.material.icons)
    implementation(project(":feature:auth:signup"))
    implementation(project(":core:datastore"))
}
