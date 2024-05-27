plugins {
    id("toongether.android.library.compose")
    id("toongether.android.feature")
}

android {
    namespace = "kr.toongether.main"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":feature:"))
}
